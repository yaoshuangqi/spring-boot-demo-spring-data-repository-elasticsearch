package com.rancho.demo.elasticsearch.repository.repository;

import com.rancho.demo.elasticsearch.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
/**
 * 接口关系：
 * ElasticsearchRepository --> ElasticsearchCrudRepository --> PagingAndSortingRepository --> CrudRepository
 * 自定义的方法，需按照给定的方式进行命名
 * 如查询，使用findBy属性，或者findBy属性1Or属性2
 * 使用规则请参考：https://blog.csdn.net/zjcjava/article/details/78691178
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByName(String name);

    Page<User> findByAge(Integer age, Pageable pageable);
}
