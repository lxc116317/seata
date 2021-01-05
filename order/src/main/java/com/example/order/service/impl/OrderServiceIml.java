package com.example.order.service.impl;

import com.example.order.domain.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.AccountService;
import com.example.order.service.OrderService;
import com.example.order.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderServiceIml implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "lxc_tx_group",rollbackFor = Exception.class)
    public void create(Order order){
        log.info("----->开始新建订单");
        //新建订单
        orderMapper.create(order);

        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束了");
    }
}
