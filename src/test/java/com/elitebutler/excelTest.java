package com.elitebutler;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.elitebutler.mapper.UserInfoMapper;
import com.elitebutler.po.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
//import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.List;

@SpringBootTest
public class excelTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    @Transactional
    void insert2Db() throws Exception {
        // 参数1：文件流
        FileInputStream stream = new FileInputStream("D:\\desk\\user.xls");
//        这里需要注意表头的行数设置一定要正确！否则集合数据将无法读取，
//        一定要区分表头与标题的区别，表头是列名称，标题是表头上面的文字，
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<UserInfo> list = ExcelImportUtil.importExcel(stream,UserInfo.class, params);

        userInfoMapper.batchInsert(list);
    }
}
