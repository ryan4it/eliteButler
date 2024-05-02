package com.elitebutler.controller;

import com.elitebutler.po.OrderPo;
import com.elitebutler.po.ProductPo;
import com.elitebutler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderPo order){
        orderService.addOrder(order);
    }
    @GetMapping("/getOrderListByStatus")
    public List<OrderPo> getOrderListByStatus(Integer status){
        return orderService.getOrderListByStatus(status);
    }

    @GetMapping("/getOrderById")
    public List<OrderPo> getOrderById(Integer id){
        return orderService.getOrderById(id);
    }
}
