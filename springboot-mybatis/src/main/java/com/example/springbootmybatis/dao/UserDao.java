package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/25
 */
public interface UserDao {

    User findById(@Param("id") Integer id);

    String findNameById(@Param("id") Integer id);

    List<User> selectAll();

    List<User> selectLikeName(@Param("userName") String name);

    List<User> selectLimit(@Param("begin") int begin,@Param("limit") int limit);

    int insert(User user);

    int insertGetId(User user);

    int update(User user);

    int delete(Long id);


    //开启事务
    void startTrans();

    //提交事务
    void commit();

    //回滚事务
    void rollback();

}
