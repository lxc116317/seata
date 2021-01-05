package com.example.order.controller;


import com.example.order.domain.Order;
import com.example.order.service.impl.OrderServiceIml;
import com.example.order.utils.result.Result;
import com.example.order.utils.result.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceIml orderService;

    @GetMapping("/order/create")
    public Result create(Order order){
        orderService.create(order);
        return new Result("订单创建成功",StatusCode.RET_SUCCESS);
    }
}
