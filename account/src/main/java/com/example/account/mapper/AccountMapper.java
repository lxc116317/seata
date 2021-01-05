package com.example.account.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;


public interface AccountMapper {

    @Update("UPDATE t_account SET    residue = residue - #{money},used = used + #{money} WHERE   user_id = #{userId};")
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
