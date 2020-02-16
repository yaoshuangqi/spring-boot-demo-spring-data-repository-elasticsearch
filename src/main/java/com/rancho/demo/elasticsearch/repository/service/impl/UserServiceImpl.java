package com.rancho.demo.elasticsearch.repository.service.impl;

import com.rancho.demo.elasticsearch.repository.entity.User;
import com.rancho.demo.elasticsearch.repository.repository.UserRepository;
import com.rancho.demo.elasticsearch.repository.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.delete(user);
        userRepository.save(user);
    }

    @Override
    public Page<User> getByAge(Integer age, PageRequest pageRequest) {

        return userRepository.findByAge(age, pageRequest);
    }
}
