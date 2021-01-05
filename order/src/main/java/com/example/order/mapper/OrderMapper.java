package com.example.order.mapper;

import com.example.order.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface OrderMapper {

    /**
     * 新建订单
     * @param order
     */
    @Insert("   insert into t_order (id,user_id,product_id,count,money,status)  " +
            "   values (null,#{userId},#{productId},#{count},#{money},0);")
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param status
     */
    @Update("   update t_order set status = 1  where user_id=#{userId} and status = #{status} ")
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
