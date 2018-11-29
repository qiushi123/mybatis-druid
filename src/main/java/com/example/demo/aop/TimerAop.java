package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by qcl on 2018/11/26
 * desc:用来计算接口请求时间的aop注解
 */
@Aspect
@Component
public class TimerAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerAop.class);
    private long start;


    @Pointcut(value = "@annotation(com.example.demo.aop.Timer)")
    public void timer() {

    }

    @Before("timer()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        start = System.currentTimeMillis();
        LOGGER.info("TimerAop：before---开始时间：" + start);
    }

    @After("timer()")
    public void after() {
        long now = System.currentTimeMillis();
        LOGGER.info("TimerAop：耗时：" + (now - start));
        LOGGER.info("TimerAop：耗时：" + (now - start) / 1000 + "秒");
    }

    @Around("@annotation(timer)")
    public Object around(ProceedingJoinPoint pjp, Timer timer) {
        //获取注解里的值
        System.out.println("TimerAop：aop传递的参数:" + timer.param());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
