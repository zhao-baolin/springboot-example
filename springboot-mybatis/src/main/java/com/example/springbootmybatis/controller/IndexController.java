package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dao.UserDao;
import com.example.springbootmybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/25
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/findById")
    public String findById(){
        //查询一条数据
        User user = userDao.findById(1);
        System.out.println(user.toString());
        return user.toString();
    }

    @RequestMapping("/findNameById")
    public String findNameById(){
        //查询单个字段
        String userName = userDao.findNameById(2);
        System.out.println(userName);
        return userName;
    }

    @RequestMapping("/selectAll")
    public String selectAll(){
        //查询多条数据
        List<User> list = userDao.selectAll();
        System.out.println(list.toString());
        return list.toString();
    }

    @RequestMapping("/selectLikeName")
    public String selectLikeName(){
        //模糊查询
        List<User> list = userDao.selectLikeName("大");
        System.out.println(list.toString());
        return list.toString();
    }

    @RequestMapping("/selectLimit")
    public String selectLimit(){
        //分页查询
        List<User> list = userDao.selectLimit(0,2);
        System.out.println(list.toString());
        return list.toString();
    }


    @RequestMapping("/insert")
    public String insert(){
        //新增数据
        User user = new User();
        user.setUserName("小王");
        user.setSex(2);
        user.setAge(12);
        Integer result = userDao.insert(user);
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/insertGetId")
    public String insertGetId(){
        //新增数据
        User user = new User();
        user.setUserName("小王aaa");
        user.setSex(1);
        user.setAge(12);
        Integer result = userDao.insertGetId(user);
        System.out.println("受影响行数是："+result.toString());
        System.out.println("新增数据的自增id是："+user.getId());

        return result.toString();
    }


    @RequestMapping("/update")
    public String update(){
        //更新
        User user = new User();
        user.setId(3L);
        user.setAge(100);
        Integer result = userDao.update(user);
        System.out.println("受影响行数是："+result.toString());
        return result.toString();
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        Integer result = userDao.delete(6L);
        System.out.println("受影响行数是："+result.toString());
        return result.toString();
    }

    //编程式事务处理
    @RequestMapping("/transaction")
    public String transaction(){

        User user = new User();
        user.setUserName("大黄");//大黄这个名字在库里已经已经存在 所以必然会报错
        user.setSex(1);
        user.setAge(22);

        //开启事务
        userDao.startTrans();
        try{
            userDao.delete(5L);//删除一条数据
            userDao.insert(user);//新增一条数据
            System.out.println("你好，走到这里证明新增语句已经执行完了");
        }catch (Exception e){
            System.out.println(e.getMessage());//打印错误详情
            userDao.rollback();//回滚事务
            return "系统异常，请稍后再试";//向客户端返回友好信息
        }
        //提交事务
        userDao.commit();
        return "操作成功";
    }

    //声明式事务处理
    // 就一个注解就完事了 被该注解声明的方法中所有数据库操作都处于事务之中，出现异常会自动回滚。  也可以将该注解声明在类上，那么类中的所有方法都自动拥有事务处理功能。
    @RequestMapping("/transaction2")
    @Transactional
    public String transaction2(){
        User user = new User();
        user.setUserName("大黄");//大黄这个名字在库里已经已经存在 所以必然会报错
        user.setSex(1);
        user.setAge(22);
        try{
            userDao.delete(5L);//删除一条数据
            userDao.insert(user);//新增一条数据
            System.out.println("你好，走到这里证明新增语句已经执行完了");
        }catch (Exception e){
            System.out.println(e.getMessage());//打印错误详情
            return "系统异常，请稍后再试";
        }
        return "操作成功";
    }








}
