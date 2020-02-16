package com.rancho.demo.elasticsearch.repository.service;

import com.rancho.demo.elasticsearch.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserService {

    void save(User user);

    void update(User user);

    User getById(String id);

    User getByName(String name);

    void delete(String id);

    Page<User> getByAge(Integer age, PageRequest pageRequest);
}
