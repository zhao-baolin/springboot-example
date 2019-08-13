package com.example.springbootdubbocore.interfaces;

import com.example.springbootdubbocore.dto.UserVo;


public interface IUserService {

    /**
     * 获取用户详情
     * @return
     */
    UserVo userDetail();

}
