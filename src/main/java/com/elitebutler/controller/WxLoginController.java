package com.elitebutler.controller;

import com.elitebutler.dto.UserDto;
import com.elitebutler.service.WxAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/user")
public class WxLoginController {
    @Autowired
    WxAuthService wxAuthService;
    // 调用该接口, 我返回openid, 你拿到openid之后, 再调用一个接口(传过来openid和身份证号), 然后我来做绑定
    @GetMapping("/getOpenid/{code}")
    public String wxLogin(@PathVariable String code){
        return wxAuthService.wxAuth(code);
    }

    @GetMapping("/getCredits/{openid}")
    public Integer getCredits(String openid){
        return wxAuthService.getCredits(openid);
    }
    @GetMapping("/setCredits/{openid}/{credits}")
    public Boolean setCredits(@PathVariable("openid") String openid, @PathVariable("credits")Integer credits){
        return wxAuthService.setCredits(openid, credits);
    }

    @GetMapping("/getIdNumber/{openid}")
    public String getIdNumber(@PathVariable("openid") String openid){
        return wxAuthService.getIdNumber(openid);
    }
    @GetMapping("/setIdNumber/{openid}/{idNumber}")
    public Boolean setCredits(@PathVariable("openid") String openid, @PathVariable("idNumber")String idNumber){
        return wxAuthService.setIdNumber(openid, idNumber);
    }

    @GetMapping("/getUserInfo/{openid}")
    public UserDto getUserInfo(@PathVariable("openid") String openid){
        return wxAuthService.getUserInfo(openid);
    }

    @GetMapping("/getEmergency/{openid}")
    public String getEmergency(@PathVariable("openid") String openid){
        UserDto userInfo = wxAuthService.getUserInfo(openid);
        return userInfo.getEmergencyContact();
    }

    @GetMapping("/setEmergency/{openid}")
    public Boolean setEmergency(@PathVariable("openid") String openid, @PathVariable("emergency")String emergency){
        return wxAuthService.setEmergency(openid, emergency);
    }
}
