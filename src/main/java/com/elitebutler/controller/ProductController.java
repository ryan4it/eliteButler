package com.elitebutler.controller;

import com.elitebutler.common.R;
import com.elitebutler.po.ProductPo;
import com.elitebutler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProductList")
    public R<List<ProductPo>> getAllProduct(){
        List<ProductPo> allProducts = productService.getAllProducts();
        return R.success(allProducts);
    }
}
