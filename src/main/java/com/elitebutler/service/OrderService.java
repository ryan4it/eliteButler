package com.elitebutler.service;

import com.elitebutler.po.OrderPo;
import com.elitebutler.po.ProductPo;

import java.util.List;

public interface OrderService {

    public void addOrder(OrderPo order);

    public List<OrderPo> getOrderListByStatus(Integer status);

    public List<OrderPo> getOrderById(Integer id);
}
