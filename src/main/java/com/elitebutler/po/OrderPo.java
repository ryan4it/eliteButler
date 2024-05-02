package com.elitebutler.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order_table")
public class OrderPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer number;

    private Integer status;

    private String userId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime orderTime;

    private Integer productId;

    private BigDecimal amount;

}
