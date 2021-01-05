package com.example.account.controller;

import com.example.account.service.AccountService;
import com.example.account.utils.result.Result;
import com.example.account.utils.result.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public Result decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return new Result("扣减账户余额成功！", StatusCode.RET_SUCCESS);
    }
}
