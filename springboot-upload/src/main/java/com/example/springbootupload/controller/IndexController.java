package com.example.springbootupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/29
 */
@Controller
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("index")
    public String index()
    {
        return "/index";
    }

    @ResponseBody
    @PostMapping("upload")
    public String upload(@RequestParam("fileUpload") MultipartFile multipartFile)
    {
        if(multipartFile.isEmpty()){
            return "没有文件上传";
        }

        String fileName = multipartFile.getOriginalFilename();
        long size = multipartFile.getSize();
        System.out.println("上传的文件名是："+fileName+"，文件大小是："+size);

        //保存目录 绝对路径
        String path = "E:\\tmp\\log\\";

        File file = new File(path,fileName);

        //创建目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try{
            //保存文件
            multipartFile.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功，上传的路径是："+file.getAbsolutePath();
    }

}
