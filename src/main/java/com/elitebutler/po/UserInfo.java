package com.elitebutler.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_info")
public class UserInfo implements Serializable {
    @Excel(name = "序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @Excel(name = "房源编号", width = 20.0)
    private String houseName;
    @Excel(name = "租客姓名")
    private String name;
    @Excel(name = "证件类型")
    private String idType;
    @Excel(name = "证件号码",width = 20.0)
    private String idNumber;
    @Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20.0)
    private LocalDateTime birthDate;
    @Excel(name = "职业")
    private String occupation;
    @Excel(name = "租金单价")
    private String rent;
    @Excel(name = "押金")
    private String deposit;
    @Excel(name = "付款方式")
    private String payMethod;


//    public static void main(String[] args) throws Exception {
//        // 参数1：文件流
//        FileInputStream stream = new FileInputStream("D:\\desk\\user.xls");
////        这里需要注意表头的行数设置一定要正确！否则集合数据将无法读取，
////        一定要区分表头与标题的区别，表头是列名称，标题是表头上面的文字，
//        ImportParams params = new ImportParams();
//        params.setTitleRows(0);
//        params.setHeadRows(1);
//        List<UserInfo> list = ExcelImportUtil.importExcel(stream,UserInfo.class, params);
//
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////        // 遍历列表中的每个数据对象
////        for (UserInfo userInfo : list) {
////            // 获取数据对象中的 LocalDateTime 字段
////            LocalDateTime dateTime = userInfo.getBirthDate();
////            // 使用格式化器将 LocalDateTime 对象格式化为日期字符串
////            String formattedDate = dateTime.format(formatter);
////            // 将格式化后的日期字符串设置回数据对象的字段中
////            userInfo.setBirthDate(LocalDateTime.parse(formattedDate, formatter));
////        }
//
//        System.out.println(list.size());
//        list.forEach(System.out::println);
//
//    }
}
