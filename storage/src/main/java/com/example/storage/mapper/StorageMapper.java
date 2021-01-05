package com.example.storage.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface StorageMapper {

    /**
     * 扣减库存信息
     * @param productId
     * @param count
     */
    @Update("   UPDATE t_storage " +
            "   SET used = used + #{count},residue = residue - #{count} WHERE " +
            "   product_id = #{productId}")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
