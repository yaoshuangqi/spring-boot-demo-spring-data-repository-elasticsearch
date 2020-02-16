package com.rancho.demo.elasticsearch;

import com.rancho.demo.elasticsearch.repository.entity.User;
import com.rancho.demo.elasticsearch.repository.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Resource
    private UserService userService;

    @Test
    public void add(){
        try{
            User user=new User();
            user.setId("20200101");
            user.setName("张三");
            user.setAge(11);
            userService.save(user);
            User user1=new User();
            user1.setId("20200102");
            user1.setName("李四");
            user1.setAge(22);
            userService.save(user1);
            User user2=new User();
            user2.setId("20200103");
            user2.setName("老鬼");
            user2.setAge(22);
            userService.save(user2);
            User user3=new User();
            user3.setId("20200104");
            user3.setName("恒其");
            user3.setAge(34);
            userService.save(user3);
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void get(){
        try{
            User user=userService.getById("20190909");
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        try{
            User user=new User();
            user.setId("20190909");
            user.setName("测试-update");
            user.setAge(22);
            userService.update(user);
            System.out.println("修改成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getByName(){
        try{
            User user=userService.getByName("张三");
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        Page<User> bb = userService.getByAge(22,PageRequest.of(0,2));
        System.out.println(bb.getContent().toString());
    }

    @Test
    public void delete(){
        try{
            userService.delete("20190909");
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
