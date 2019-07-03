package com.example.springbootmongodb.service.impl;

import com.example.springbootmongodb.entity.User;
import com.example.springbootmongodb.service.IUserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/4
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String insert(User user) {


        //User user1 = mongoTemplate.insert(user);  //默认存在实体对象名对应的文档表中

        //User user1 = mongoTemplate.insert(user,"user2"); //存储在user2文档表中


        //存储零散自定义数据
        HashMap hashMap = new HashMap();
        hashMap.put("aaa","啊啊啊");
        hashMap.put("bbb","哈哈");
        HashMap hashMap1 = new HashMap();
        hashMap1.put("c1","c1哈");
        hashMap1.put("c2","c2哈");
        hashMap.put("ccc",hashMap1);
        HashMap map = mongoTemplate.insert(hashMap,"user");

        return map.toString();
    }

    @Override
    public Object findById(Long id) {

        //根据主键id查询 结果转成实体对象
        User obj = mongoTemplate.findById(id,User.class);

        //由于添加的时候数据库记录了实体位置  所以尽管用Object接收 实际上还是自动转成了User对象  User对象属性之外的字段列会被自动舍弃
        //User obj = (User)mongoTemplate.findById(id,Object.class,"user");

        //返回数据类型为 LinkedHashMap
        //Object obj = mongoTemplate.findById("5d1ce0d8115f78559bf94f10",Object.class,"user");

        return obj;
    }

    @Override
    public Object find() {

        Criteria criteria = Criteria.where("user_name").is("小张飞");
        Query query = Query.query(criteria);

        //获取符合条件的一条数据
        User obj = mongoTemplate.findOne(query,User.class);
        return obj;
    }

    @Override
    public String select() {

        //单条件查询
/*
        Criteria criteria = Criteria.where("user_name").is("小张飞");
        Query query = Query.query(criteria);
        List<User> list = mongoTemplate.find(query,User.class);
*/

        //多条件查询
/*
        Criteria criteria = Criteria.where("user_name").is("小张飞").and("age").is(111);
        Query query = Query.query(criteria);
        List<User> list = mongoTemplate.find(query,User.class);
*/


        //模糊查询
/*
        Criteria criteria = Criteria.where("user_name").regex("张");
        Query query = Query.query(criteria);
        List<User> list = mongoTemplate.find(query,User.class);
*/

        //分页查询
        Criteria criteria = new Criteria();
        Query query = Query.query(criteria).skip(0).limit(10);
        List<Object> list = mongoTemplate.find(query,Object.class,"user");

        System.out.println(list.toString());
        return "大爷，快看控制台";
    }

    @Override
    public Long count() {
        //条数查询
        Query query = new Query();
        Long count = mongoTemplate.count(query,"user");
        return count;
    }

    @Override
    public Long update(Long id, String userName, Integer age) {

        Criteria criteria = Criteria.where("_id").is(id);//条件 这里有非常多的方法 all and  lt gt in 等等
        Query query = Query.query(criteria);

        Update update = Update.update("user_name2",userName);//更新 没有该key会新增
        update.set("age",age);//更新 没有该key会新增
        update.rename("sex","new_sex");//改key名
        // update.inc("age",20); 自增


        //更新符合条件的第一个文档
        UpdateResult result = mongoTemplate.updateFirst(query,update,"user");

        //更新符合条件的全部文档
        //UpdateResult result2 = mongoTemplate.updateMulti(query,update,"user");

        Long matchedCount = result.getMatchedCount();
        System.out.println("符合条件的数据量："+matchedCount);

        Long modifiedCount = result.getModifiedCount();
        System.out.println("修改的数据量："+modifiedCount);

        return modifiedCount;
    }

    @Override
    public Long delete() {

        //删除数据
        Criteria criteria = Criteria.where("_id").is("5d1ce0d8115f78559bf94f10");
        Query query = Query.query(criteria);

        DeleteResult result = mongoTemplate.remove(query,"user");

        Long deletedCount = result.getDeletedCount();
        System.out.println("删除的数据量："+deletedCount);

        return deletedCount;
    }

}
