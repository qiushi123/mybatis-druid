package com.example.demo.elasticsearch;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by qcl on 2018/12/9
 * desc:
 */
@RestController
@RequestMapping("/es")
public class EsUserController {
    @Resource
    EsUserService userService;

    //增加
    @PostMapping("/add")
    @ResponseBody
    public EsUser add(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "desc") String desc,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "creatTime")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    Date creatTime
    ) {
        EsUser user = new EsUser();
        user.setId(id);
        user.setName(name);
        user.setDesc(desc);
        user.setAge(age);
        user.setCreatTime(creatTime);
        return userService.insert(user);
    }

    //查找
    @RequestMapping("/search")
    public List<EsUser> search(@RequestParam(name = "key") String key) {
        List<EsUser> userList = userService.search(key);
        return userList;
    }

    //模糊查找
    @RequestMapping("/searchfuzzy")
    public List<EsUser> searchfuzzy(@RequestParam(name = "key") String key) {
        List<EsUser> users = userService.searchfuzzy(key);
        return users;
    }

    //模糊查找2
    @RequestMapping("/searchfuzzy2")
    public List<EsUser> searchfuzzy2(@RequestParam(name = "key") String key) {
        List<EsUser> users = userService.searchfuzzy2(key);
        return users;
    }

    //查找
    @GetMapping("/getOneById")
    public EsUser getOneById(@RequestParam(name = "id") long id) {
        return userService.getOneById(id);
    }

    @RequestMapping("/findAll")
    public Iterable<EsUser> findAll() {
        Iterable<EsUser> all = userService.findAll();
        return all;
    }
}
