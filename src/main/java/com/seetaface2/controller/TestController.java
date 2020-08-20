package com.seetaface2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yaosh
 * @version 1.0
 * @commpany 星瑞国际
 * @date 2020/8/20 14:30
 * @return
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "abc";
    }
}
