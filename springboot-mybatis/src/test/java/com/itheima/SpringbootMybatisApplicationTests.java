package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }


    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println("删除了"+i+"行数据");
    }

    @Test
    public void testInsert() {
        User user = new User(null, "gaoyuanyuan", "123456", "高圆圆", 18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "gaoyuanyuan", "123456", "高圆圆", 18);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("xiaoqiao", "123456");
        System.out.println(user);
    }
}
