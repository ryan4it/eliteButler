package com.elitebutler.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.elitebutler.dto.UserDto;
import com.elitebutler.exception.EliteButlerException;
import com.elitebutler.mapper.UserInfoMapper;
import com.elitebutler.mapper.WxUserMapper;
import com.elitebutler.po.UserInfo;
import com.elitebutler.po.WxUser;
import com.elitebutler.service.WxAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class WxAuthServiceImpl implements WxAuthService {
    @Autowired
    WxUserMapper wxUserMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    RestTemplate restTemplate;
//    @Autowired
//    PlatformTransactionManager transactionManager;


    @Override
    public String wxAuth(String code) {
        // 通过授权码申请令牌,
        Map<String, String> openids = get_openids(code);
//        // 将用户信息存入数据库
//        WxUser wxUser = addWxUser2Db(openids);
        return openids.get("openid");
    }

    @Override
    public Integer getCredits(String openid) {
        WxUser wxUser = wxUserMapper.selectOne(new LambdaQueryWrapper<WxUser>().eq(WxUser::getId, openid));
        return wxUser.getCerdits();
    }

    @Override
    public Boolean setCredits(String openid, Integer credits) {
        WxUser wxUser = wxUserMapper.selectById(openid);
        LambdaUpdateWrapper<WxUser> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(WxUser::getCerdits, credits);
        int update = wxUserMapper.update(wxUser, updateWrapper);
        if (update <= 0){
            EliteButlerException.cast("更新积分失败");
            return false;
        }
        return true;
    }

    @Override
    public String getIdNumber(String openid) {
        WxUser wxUser = wxUserMapper.selectById(openid);
        return wxUser.getIdNumber();
    }

    @Override
    public Boolean setIdNumber(String openid, String idNumber) {
        WxUser wxUser = wxUserMapper.selectById(openid);
        wxUser.setIdNumber(idNumber);
        int update = wxUserMapper.updateById(wxUser);
        if (update <= 0){
            EliteButlerException.cast("更新身份证号失败");
            return false;
        }
        return true;
    }

    @Override
    public UserDto getUserInfo(String openid) {
        WxUser wxUser = wxUserMapper.selectById(openid);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(wxUser,userDto);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getIdNumber, wxUser.getIdNumber());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        BeanUtils.copyProperties(userInfo, userDto);
        return userDto;
    }

    @Override
    public Boolean setEmergency(String openid, String emergency) {
        WxUser wxUser = wxUserMapper.selectById(openid);
        wxUser.setEmergencyContact(emergency);
        int update = wxUserMapper.updateById(wxUser);
        if (update <= 0){
            EliteButlerException.cast("更新联系人失败");
            return false;
        }
        return null;
    }

    /**
     * 携带授权码申请令牌
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     * 返回结果:
     * {
     * "openid":"xxxxxx",
     * "session_key":"xxxxx",
     * "unionid":"xxxxx",
     * "errcode":0,
     * "errmsg":"xxxxx"
     * }
     *
     * appid: wxed9954c01bb89b47
     * secret: a7482517235173ddb4083788de60b90e
     * @param code
     * @return
     */
    private Map<String, String> get_openids(String code){
        String rawUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        String url = String.format(rawUrl, "wx6a933731da44bb74", "4834761af511f00da1b01b23af23e1d6", code);
        // 远程调用url
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
        // 获取响应结果
        String json = new String(exchange.getBody().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);// 就是返回结果
        Map<String, String> resultMap = JSON.parseObject(json, Map.class);


        return resultMap;
    }



//    @Transactional
//    public WxUser addWxUser2Db(Map<String, String> openids){
//        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
//        return transactionTemplate.execute(new TransactionCallback<WxUser>() {
//            @Override
//            public WxUser doInTransaction(TransactionStatus transactionStatus) {
////                String unionid = userInfo.get("unionid").toString();
//                WxUser wxUser = wxUserMapper.selectOne(new LambdaQueryWrapper<WxUser>().eq(WxUser::getId, openids.get("openid")));
//                // 用户已存在
//                if (wxUser != null){
//                    return wxUser;
//                }
//                // 用户不存在, 新增
////                String userId = UUID.randomUUID().toString();
//                wxUser = new WxUser();
//                wxUser.setId(openids.get("openid"));
//                wxUser.setUnionid(openids.get("unionid"));
//                wxUser.setEmergencyContact(null);
//
//                wxUserMapper.insert(wxUser);
//                return wxUser;
//            }
//        });
//    }

}
