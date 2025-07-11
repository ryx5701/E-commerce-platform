package com.hmall.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.hmall.api.dto.OrderDetailDTO;
import com.hmall.item.domain.po.Item;
import feign.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface ItemMapper extends BaseMapper<Item> {

    @Update("UPDATE item SET stock = stock - #{num} WHERE id = #{itemId}")
    void updateStock(OrderDetailDTO orderDetail);
    int recoverStock(@Param("orderMap") Map<Long, Integer> orderMap);

}
