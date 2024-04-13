package com.elitebutler.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elitebutler.po.TestPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface TestMapper extends BaseMapper<TestPo> {
//    @Select("select * from test where id=#{id}")
//    TestPo test(@Param("id") Integer id);
}
