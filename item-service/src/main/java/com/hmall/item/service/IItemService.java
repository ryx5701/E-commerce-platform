package com.hmall.item.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.hmall.api.dto.ItemDTO;
import com.hmall.api.dto.OrderDetailDTO;
import com.hmall.item.domain.po.Item;


import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface IItemService extends IService<Item> {
    void deductStock(List<OrderDetailDTO> items);

    List<ItemDTO> queryItemByIds(Collection<Long> ids);

    void recoverStock(Map<Long, Integer> orderMap);

}
