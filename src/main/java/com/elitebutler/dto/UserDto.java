package com.elitebutler.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.elitebutler.po.WxUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer vipLevel;

    private Integer cerdits;

    private String gender;

    private String idNumber;

    private String houseName;

    private LocalDateTime birthDate;

    private String rent;

    private String deposit;

    private String occupation;

    private String payMethod;

    private String emergencyContact;



}
