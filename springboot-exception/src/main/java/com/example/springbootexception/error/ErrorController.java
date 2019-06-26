package com.example.springbootexception.error;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
@Controller
public class ErrorController extends AbstractErrorController {

    @Autowired
    ObjectMapper objectMapper;

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    @ResponseBody
    public BaseRs getErrorPath(HttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> model = Collections.unmodifiableMap(getErrorAttributes(request,false));

        //获取异常 可将异常打印到日志
        Throwable cause = getCause(request);
        int status = (Integer)model.get("status");

        //自定义友好错误信息
        String msg = (String)model.get("message");

        JSONObject object = JSONObject.parseObject(msg);
        int code = object.getInteger("code");
        String message = object.getString("message");

        return new BaseRs(code,message);
    }


    protected Throwable getCause(HttpServletRequest request)
    {
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
        if(null == error){
            //MVC有可能会封装异常成ServletException ,需要调用getCause获取真正的异常
            while (error instanceof ServletException && error.getCause() != null){
                error = ((ServletException) error).getCause();
            }
        }
        return error;
    }
}