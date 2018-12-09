package com.example.demo.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 其中主要的方法就是 save、delete和search。
 * 其中save方法相当如insert和update，没有就新增，有就覆盖。
 * delete方法主要就是删除数据以及索引库。
 * 至于search就是查询了，包括一些常用的查询，如分页、权重之类的。
 */
public interface EsUserRepository extends ElasticsearchRepository<EsUser, Long> {
    EsUser getUserById(long id);
}