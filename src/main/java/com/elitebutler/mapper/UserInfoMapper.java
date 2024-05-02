package com.elitebutler.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elitebutler.po.OrderPo;
import com.elitebutler.po.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    void batchInsert(@Param("userInfos") List<UserInfo> userInfos);
}

