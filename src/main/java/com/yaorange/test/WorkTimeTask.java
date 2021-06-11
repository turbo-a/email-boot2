package com.yaorange.test;

import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/29.
 * 计时器任务管理类
 */
public class WorkTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}
