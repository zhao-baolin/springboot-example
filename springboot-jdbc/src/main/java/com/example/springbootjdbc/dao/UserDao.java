package com.example.springbootjdbc.dao;

import com.example.springbootjdbc.entity.User;
import com.example.springbootjdbc.enums.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @Description  SQL文件在resources目录下，请自行查找
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //查询列表
    public List<User> selectAll(int begin,int limit){

        //SQL
        String sql = "select * from tb_user limit ?,?";

        //参数
        Object[] params = {begin,limit};

        //查询SQL返回对象实体
        List<User> list = jdbcTemplate.query(sql,getUserMapper(),params);

        //你也可以直接返回Map 最简单省事
        //List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql);

        return list;
    }

    //查询单条数据
    public User findUser(Long id){
        String sql = "select * from tb_user where id = ?";
        Object[] params = {id};

        //Map map = jdbcTemplate.queryForMap(sql,params); //直接返回Map

        return jdbcTemplate.queryForObject(sql,getUserMapper(),params);
    }


    //新增数据
    public int insertUser(User user){
        String sql = "insert into tb_user (user_name,sex,age) values(?,?,?)";
        Object[] params = {user.getUserName(),user.getSex(),user.getAge()};
        return jdbcTemplate.update(sql,params);
    }

    //新增数据返回自增id
    public Long insertGetId(User user){
        String sql = "insert into tb_user (user_name,sex,age) values(?,?,?)";
        Object[] params = {user.getUserName(),user.getSex(),user.getAge()};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,new String[]{"id"});//指定主键名

                //参数
                ps.setString(1,user.getUserName());
                ps.setInt(2,user.getSex());
                ps.setInt(3,user.getAge());
                return ps;
            }
        }, keyHolder);
        Long id = keyHolder.getKey().longValue();
        return id;
    }

    //更新
    public int updateUser(User user){
        String sql = "update tb_user set age = ? where id = ?";
        Object[] params = {user.getAge(),user.getId()};
        return jdbcTemplate.update(sql,params);
    }

    //删除
    public int delete(Long id){
        String sql = "delete from tb_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }


    //事务处理用execute执行事务语句即可
    //开启事务：jdbcTemplate.execute("START TRANSACTION");
    //回滚事务：jdbcTemplate.execute("ROLLBACK");
    //提交事务：jdbcTemplate.execute("COMMIT");


    //字段映射到实体
    private RowMapper<User> getUserMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            user.setSex(rs.getInt("sex"));
            user.setAge(rs.getInt("age"));
            return user;
        };
        return userRowMapper;
    }

}
