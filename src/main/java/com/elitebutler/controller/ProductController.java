package com.elitebutler.controller;

import com.elitebutler.common.R;
import com.elitebutler.po.ProductPo;
import com.elitebutler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProductList")
    public List<ProductPo> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProductByType/{type}")
    public List<ProductPo> getProductByType(@PathVariable("type") String type){
        List<ProductPo> products = productService.getProductByType(type);
        return products;
    }

    @GetMapping("/getProductByType/{id}")
    public List<ProductPo> getProductById(@PathVariable("id") String id){
        List<ProductPo> products = productService.getProductByType(id);
        return products;
    }
}
