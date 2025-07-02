package com.hmall.cart.listener;


import com.hmall.cart.service.ICartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCartListener {
private  final ICartService cartService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "cart.clear.queue", durable = "true"),
            exchange = @Exchange(name = "trade.topic"),
            key = "order.create"
    ))
    public void listenDeleteCart(List<Long> itemIds){
        log.info("收到购物车清理消息，itemIds: {}", itemIds);
            cartService.removeByItemIds(itemIds);

    }
}