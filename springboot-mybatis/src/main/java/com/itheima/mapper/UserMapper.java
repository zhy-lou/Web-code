package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id, username, password, name, age from user")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);

    @Insert("insert into user values(#{id},#{username},#{password},#{name},#{age})")
    public Integer insert(User user);

    @Update("update user set username = #{username}," +
            " password = #{password}, " +
            "name = #{name}, " +
            "age = #{age} " +
            "where id = #{id}")
    public Integer update(User user);

    @Select("select id, username, password, name, age from user " +
            "where username = #{username} and " +
            "password =#{password}")
    public User findByUsernameAndPassword(String username,
                                          String password);
}
