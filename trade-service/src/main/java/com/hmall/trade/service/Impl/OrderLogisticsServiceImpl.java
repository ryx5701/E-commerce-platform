package com.hmall.trade.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.trade.domain.po.OrderLogistics;
import com.hmall.trade.mapper.OrderLogisticsMapper;
import com.hmall.trade.service.IOrderLogisticsService;
import org.springframework.stereotype.Service;


@Service
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements IOrderLogisticsService {

}
