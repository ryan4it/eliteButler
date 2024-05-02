package com.elitebutler.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 */
@Data
@TableName("wx_user")
public class WxUser implements Serializable {

    private static final long serialVersionUID = 1L;

    // openid
    private String id;

    private String unionid;

    private String idNumber;

    private String emergencyContact;

    private Integer vipLevel;

    private Integer cerdits;

    private String gender;

    private String phoneNumber;

}
