package com.elitebutler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elitebutler.mapper.OrderMapper;
import com.elitebutler.po.OrderPo;
import com.elitebutler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void addOrder(OrderPo order) {
        orderMapper.insert(order);
    }

    @Override
    public List<OrderPo> getOrderListByStatus(Integer status) {
        LambdaQueryWrapper<OrderPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderPo::getStatus, status);
        List<OrderPo> orderPos = orderMapper.selectList(queryWrapper);
        return orderPos;
    }

    @Override
    public List<OrderPo> getOrderById(Integer id) {
        LambdaQueryWrapper<OrderPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderPo::getId, id);
        List<OrderPo> orderPos = orderMapper.selectList(queryWrapper);
        return orderPos;
    }
}
