package com.example.demo.elasticsearch;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

@Service
public class EsUserService {

    @Resource
    private EsUserRepository esUserRepository;

    //添加数据
    EsUser insert(EsUser user) {
        try {
            EsUser user1 = esUserRepository.save(user);
            return user1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据id查询数据
    EsUser getOneById(long id) {
        return esUserRepository.getUserById(id);
    }

    Iterable<EsUser> findAll() {
        Iterable<EsUser> all = esUserRepository.findAll();
        return all;
    }


    List<EsUser> searchfuzzy(String name) {
        QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", name);
        Iterable<EsUser> searchAll = esUserRepository.search(queryBuilder);

        List<EsUser> list = new ArrayList<>();
        for (EsUser u : searchAll) {
            list.add(u);
        }
        return list;
    }

    //和上面searchfuzzy一样
    List<EsUser> searchfuzzy2(String key) {
        WildcardQueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name",
                "*" + key + "*");//搜索名字中含有key文档（name中只要包含key即可）
        Iterable<EsUser> searchAll = esUserRepository.search(queryBuilder);

        List<EsUser> list = new ArrayList<>();
        for (EsUser u : searchAll) {
            list.add(u);
        }
        return list;
    }

    List<EsUser> search(String searchContent) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        System.out.println("查询的语句:" + builder);
        Iterable<EsUser> searchResult = esUserRepository.search(builder);
        Iterator<EsUser> iterator = searchResult.iterator();
        List<EsUser> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    public List<EsUser> searchUser(Integer pageNumber, Integer pageSize, String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(builder).build();
        System.out.println("查询的语句:" + searchQuery.getQuery().toString());
        Page<EsUser> searchPageResults = esUserRepository.search(searchQuery);
        return searchPageResults.getContent();
    }

}