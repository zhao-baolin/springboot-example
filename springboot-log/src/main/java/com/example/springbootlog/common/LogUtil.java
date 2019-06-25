package com.example.springbootlog.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/25
 */
public class LogUtil {

    /**
     * 日志级别
     */
    public enum LevelEnum{
        trace, debug, info, warn, error;
    }

    /**
     * 默认打印级别
     */
    private String defaulLevel = LevelEnum.info.name();


    /**
     * 日志入口
     * @param smg
     */
    public static void log(String smg){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];

        LogUtil logUtil = new LogUtil();
        Logger logger = logUtil.getLogger(stackTraceElement);

        String title = stackTraceElement.getMethodName()+"  "+stackTraceElement.getLineNumber()+"行  ";
        logUtil.print(logger,logUtil.defaulLevel,title+smg);
    }

    /**
     * 日志入口
     * @param level
     * @param smg
     */
    public static void log(LevelEnum level,String smg){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[2];

        LogUtil logUtil = new LogUtil();
        Logger logger = logUtil.getLogger(stackTraceElement);

        String title = stackTraceElement.getMethodName()+"  "+stackTraceElement.getLineNumber()+"行  ";

        logUtil.print(logger,level.name(),title+smg);
    }

    /**
     * 打印
     * @param logger
     * @param level
     * @param content
     */
    private void print(Logger logger, String level, String content){
        try{
            Method m = logger.getClass().getDeclaredMethod(level,String.class);
            m.invoke(logger,content);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取实例
     * @param stackTraceElement
     * @return
     */
    private Logger getLogger(StackTraceElement stackTraceElement){
        Class cla = null;
        try{
            cla = Class.forName(stackTraceElement.getClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return LoggerFactory.getLogger(cla);
    }

}
