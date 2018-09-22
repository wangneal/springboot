package com.bcfou.controller;

import com.bcfou.inerface.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 编程否
 * @Date: 2018/9/22 17:04
 */
@RestController
public class TestController {
    /**
     * 简单方法示例
     * @param hello
     * @return
     */
    @RequestMapping("/aop")
    @Log(value="请求了aopDemo方法")
    public String aopDemo(String hello) {
        return "请求参数为：" + hello;
    }

    /**
     * 不拦截日志示例
     * @param hello
     * @return
     */
    @RequestMapping("/notaop")
    @Log(ignore=true)
    public String notAopDemo(String hello) {
        return "此方法不记录日志，请求参数为：" + hello;
    }
}
