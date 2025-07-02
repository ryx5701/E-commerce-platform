package com.hmall.trade.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.api.client.ItemClient;
import com.hmall.trade.domain.po.OrderDetail;
import com.hmall.trade.mapper.OrderDetailMapper;
import com.hmall.trade.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
    private final ItemClient itemClient;

    @Override
    public void recoverStock(Long orderId) {
        List<OrderDetail> orderDetailList = this.lambdaQuery().eq(OrderDetail::getOrderId, orderId).list();
        Map<Long, Integer> orderMap = orderDetailList.stream()
                .collect(Collectors.toMap(OrderDetail::getItemId, OrderDetail::getNum));
        itemClient.recoverStock(orderMap);

    }
}
