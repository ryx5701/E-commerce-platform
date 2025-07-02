package com.hmall.trade.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmall.trade.domain.po.Order;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface OrderMapper extends BaseMapper<Order> {
@Update("update `order` set status = 3 where id = #{orderId}")
    void updatePayStatusById(Long orderId);
}
