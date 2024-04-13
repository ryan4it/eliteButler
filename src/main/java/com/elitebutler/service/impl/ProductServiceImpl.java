package com.elitebutler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elitebutler.mapper.ProductMapper;
import com.elitebutler.po.ProductPo;
import com.elitebutler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductPo> getAllProducts() {
        LambdaQueryWrapper<ProductPo> queryWrapper = new LambdaQueryWrapper<>();
        return productMapper.selectList(queryWrapper);
    }
}
