package cn.hanpeng.quartz.task;

import cn.hanpeng.quartz.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 *
 * @author hanpeng
 */
@Component("task")
public class QuartzTask {
    public void quartzMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void quartzParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void quartzNoParams() {
        System.out.println("执行无参方法");
    }
}
