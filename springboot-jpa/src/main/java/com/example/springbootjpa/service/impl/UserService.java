package com.example.springbootjpa.service.impl;

import com.example.springbootjpa.dao.UserRepository;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> selectAll() {


        //查询所有数据
        //List<User> list = userRepository.findAll();


        //按id降序
        //List<User> list = userRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));


        //按age升序
        //List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC,"age"));


        //分页查询
/*
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<User> userPage = userRepository.findAll(pageRequest);
        int pages = userPage.getTotalPages();//总页数
        Long counts = userPage.getTotalElements();//数据总条数
        List<User> list = userPage.getContent();//数据集
*/

        //当然 你也可以这样子把排序也放进去一起
        //PageRequest pageRequest2 = PageRequest.of(0,2,Sort.Direction.ASC,"age");



        //根据一批id查询
/*
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<User> list = userRepository.findAllById(ids);
*/




        //以下为自定义查询方法：
        //你可以根据这几种前缀规则来定义你想要的方法：findBy, readBy, queryBy, countBy, and getBy  这里演示一些常用的查询


        //根据Sex来查询，方法都要在UserRepository中定义，无需实现。
        //List<User> list = userRepository.findBySex(1);

        //根据Sex来查询并且age倒序
        //List<User> list = userRepository.findBySexOrderByAgeDesc(1);

        //根据Sex来查询并且age倒序 并且只查1条记录
        //List<User> list = userRepository.findFirst1BySexOrderByAgeDesc(1);

        //模糊查询
        List<User> list = userRepository.findByUserNameLike("%花%");

        //更多查询请查看当前目录下的图片jpa命名关键字.png


        return list;
    }

    @Override
    public User find() {

        //根据主键id来查询
        //User user = userRepository.getOne(2L);

        //根据某个字段来查询
        //这里为什么以getBy开头而不是findBy了呢？ 如果你用findBy开头也是可以的 但是我们应该设计的干净一些 比如查多条数据就用findBy打头  查一条数据就用getBy打头 防止混淆
        User user = userRepository.getByUserName("小花");

        return user;
    }

    @Override
    public User add() {

        User user = new User();

        user.setUserName("大黄");
        user.setSex(1);
        user.setAge(18);

        //添加数据
        User result = userRepository.saveAndFlush(user);
        //还有一个save方法，是将数据保存在了内存中，不会立刻提交到数据库。

        System.out.println(result.toString());
        return result;
    }

    @Override
    public List<User> addAll() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("大黄1");
        user1.setSex(1);
        user1.setAge(33);

        User user2 = new User();
        user2.setUserName("大黄2");
        user2.setSex(2);
        user2.setAge(53);

        User user3 = new User();
        user3.setUserName("大黄3");
        user3.setSex(1);
        user3.setAge(23);

        list.add(user1);
        list.add(user2);
        list.add(user3);

        //批量添加
        List<User> result = userRepository.saveAll(list);
        return result;
    }

    @Override
    public User update() {
        User user = new User();

        user.setId(3L);
        user.setUserName("大黄");
        user.setSex(1);
        user.setAge(10);

        //更新和添加都是一样一样的，你传了id它就给你修改，你没传id它就给你新增
        User result = userRepository.saveAndFlush(user);

        System.out.println(result.toString());
        return null;
    }

    @Override
    public int delete() {

        //根据id来删
        //Long id = 5L;
        //userRepository.deleteById(id);

        //根据对象来删
        //User user = userRepository.getOne(3L);
        //userRepository.delete(user);

        //批量删
        //List<User> users = userRepository.findBySex(5);
        //userRepository.deleteAll(users);

        return 1;
    }
}
