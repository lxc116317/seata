package com.example.account.service;

import com.example.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountMapper accountMapper;


    public void decrease(Long userId, BigDecimal money){

        System.out.println("------->account-service中扣减账户余额开始");

        int i=10/0;
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountMapper.decrease(userId,money);

        System.out.println("------->account-service中扣减账户余额结束");
    }
}
