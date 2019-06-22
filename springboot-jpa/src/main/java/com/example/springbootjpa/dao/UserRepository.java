package com.example.springbootjpa.dao;

import com.example.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
public interface UserRepository extends JpaRepository<User,Long> {


    List<User> findBySex(Integer sex);

    List<User> findBySexOrderByAgeDesc(Integer sex);

    List<User> findFirst1BySexOrderByAgeDesc(Integer sex);

    List<User> findByUserNameLike(String name);


    User getByUserName(String userName);

}
