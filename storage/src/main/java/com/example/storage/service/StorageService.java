package com.example.storage.service;

import com.example.storage.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageService {

    @Resource
    private StorageMapper storageMapper;


    public void decrease(Long productId, Integer count){

        System.out.println("------->storage-service中扣减库存开始");

        storageMapper.decrease(productId,count);

        System.out.println("------->storage-service中扣减库存结束");
    }
}
