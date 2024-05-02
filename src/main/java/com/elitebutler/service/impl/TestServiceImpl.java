package com.elitebutler.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.elitebutler.mapper.UserInfoMapper;
import com.elitebutler.po.UserInfo;
import com.elitebutler.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Transactional
    public void insert1Db()  {
        List<UserInfo> list = null;
        try {
            // 参数1：文件流
            FileInputStream stream = new FileInputStream("D:\\desk\\user.xls");
//        这里需要注意表头的行数设置一定要正确！否则集合数据将无法读取，
//        一定要区分表头与标题的区别，表头是列名称，标题是表头上面的文字，
            ImportParams params = new ImportParams();
            params.setTitleRows(0);
            params.setHeadRows(1);
            list = ExcelImportUtil.importExcel(stream, UserInfo.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            userInfoMapper.insert(list.get(i));
        }

    }

    @Transactional
    public void insert2Db()  {
        List<UserInfo> list = null;
        try {
            // 参数1：文件流
            FileInputStream stream = new FileInputStream("D:\\desk\\user.xls");
//        这里需要注意表头的行数设置一定要正确！否则集合数据将无法读取，
//        一定要区分表头与标题的区别，表头是列名称，标题是表头上面的文字，
            ImportParams params = new ImportParams();
            params.setTitleRows(0);
            params.setHeadRows(1);
            list = ExcelImportUtil.importExcel(stream, UserInfo.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(list.get(0));
        userInfoMapper.batchInsert(list);
    }
}
