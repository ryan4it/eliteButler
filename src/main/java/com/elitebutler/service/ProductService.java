package com.elitebutler.service;

import com.elitebutler.po.ProductPo;

import java.util.List;

public interface ProductService {
    public List<ProductPo> getAllProducts();

    public List<ProductPo> getProductByType(String type);

    public List<ProductPo> getProductById(String id);
}
