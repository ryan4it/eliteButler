package com.elitebutler.service;

import com.elitebutler.dto.UserDto;

/**
 * 微信扫码接入
 */
public interface WxAuthService {
    /**
     * 微信扫码认证, 申请令牌, 携带令牌查询用户信息, 将用户信息存入数据库
     * @param code
     * @return
     */
    public String wxAuth(String code);

    public Integer getCredits(String openid);

    public Boolean setCredits(String openid, Integer credits);

    public String getIdNumber(String openid);

    public Boolean setIdNumber(String openid, String idNumber);

    public UserDto getUserInfo(String openid);

    public Boolean setEmergency(String openid, String emergency);
}
