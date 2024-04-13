package com.elitebutler.controller;

import com.elitebutler.mapper.TestMapper;
import com.elitebutler.po.TestPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestMapper testMapper;

    @GetMapping("/test")
    public TestPo getTestData(){
        //        System.out.println(testPo);
        TestPo testPo = testMapper.selectById(1);
        System.out.println(testPo);
        return testPo;
    }

    @GetMapping("/testt")
    public String testtt(){
        System.out.println(1);
        return "123";
    }
}
