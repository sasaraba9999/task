package com.example.task.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    //ログイン認証
    @Select("select userName,pass,authority from users where userName = #{username}")
    Optional<User> findByUsername(String username);

    //ユーザー登録
    @Insert("insert into users (username,pass,authority) values(#{username},#{password},'ADMIN')")
    void insert(String username ,String password);

}
