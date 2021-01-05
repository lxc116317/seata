package com.example.storage.controller;

import com.example.storage.service.StorageService;
import com.example.storage.utils.result.Result;
import com.example.storage.utils.result.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new Result("扣减库存成功！", StatusCode.RET_SUCCESS);
    }
}
