package com.elitebutler.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.elitebutler.mapper.TestMapper;
import com.elitebutler.mapper.UserInfoMapper;
import com.elitebutler.po.TestPo;
import com.elitebutler.po.UserInfo;
import com.elitebutler.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestMapper testMapper;
    @Autowired
    TestService testService;

//    @GetMapping("/test")
//    public TestPo getTestData(){
//        //        System.out.println(testPo);
//        TestPo testPo = testMapper.selectById(1);
//        System.out.println(testPo);
//        return testPo;
//    }
//
//    @GetMapping("/testt")
//    public String testtt(){
//        System.out.println(1);
//        return "123";
//    }

    @GetMapping("/excel")
    public void testExcel(){
        testService.insert1Db();
    }
}
