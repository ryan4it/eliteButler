package com.elitebutler.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("test")
public class TestPo {
    private Integer id;

    private String name;
}
