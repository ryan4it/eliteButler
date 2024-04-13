package com.elitebutler.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("product_table")
public class ProductPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String productName;

    private String productType;

    private Float price;

    private Float creditPrice;

    private Integer stock;

    private String imgUrl;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String createUser;
}
