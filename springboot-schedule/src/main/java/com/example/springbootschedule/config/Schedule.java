package com.example.springbootschedule.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/30
 */
@Service
public class Schedule {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    //fixedRate设置间隔时间 单位秒
    @Scheduled(fixedRate = 10000)
    public void a(){
        System.out.println("每隔10秒钟执行一次："+format.format(new Date()));
    }


    @Scheduled(cron = "0 20-25 14 * * *")
    public void b(){
        System.out.println("今天下午14点20-25分钟之间每分钟跑一次："+format.format(new Date()));
    }


    @Scheduled(cron = "0/10 * * * * *")
    public void c(){
        System.out.println("我也是每十秒跑一次："+format.format(new Date()));
    }

    //cron表达式 ：秒、分、时、日、月、年
    /*

    * 表示所有值。在分钟里表示每一分钟触发。在小时，日期，月份等里面表示每一小时，每一日，每一月。
    ？表示不指定值。表示不关心当前位置设置的值。 比如不关心是周几，则周的位置填写？
    - 表示区间。小时设置为10-12表示10,11,12点均会触发。
    ，表示多个值。 小时设置成10,12表示10点和12点会触发。
    / 表示递增触发。 5/15表示从第5秒开始，每隔15秒触发。


    示例 
    "0 0 12 * * ?" 每天中午12点触发 
    "0 15 10 ? * *" 每天上午10:15触发 
    "0 15 10 * * ?" 每天上午10:15触发 
    "0 15 10 * * ? 2005" 2005年的每天上午10:15触发 
    "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 
    "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 
    "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
    "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 
    "0 15 10 15 * ?" 每月15日上午10:15触发 
    "0 15 10 L * ?" 每月最后一日的上午10:15触发 

    */
}
