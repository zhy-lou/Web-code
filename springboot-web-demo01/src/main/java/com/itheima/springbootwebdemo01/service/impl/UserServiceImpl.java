package com.itheima.springbootwebdemo01.service.impl;

import com.itheima.springbootwebdemo01.dao.UserDao;
import com.itheima.springbootwebdemo01.dao.impl.UserDaoImpl;
import com.itheima.springbootwebdemo01.pojo.user;
import com.itheima.springbootwebdemo01.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<user> findAll() {

        List<String> lines = userDao.findAll();

        List<user> userList = lines.stream().map(line ->
        {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new user(id, username, password, name, age, updateTime);
        }).toList();


        return userList;
    }
}
