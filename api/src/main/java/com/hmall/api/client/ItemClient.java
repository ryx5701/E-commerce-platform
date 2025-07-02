package com.hmall.api.client;


 import com.hmall.api.client.fallback.ItemClientFallback;
 import com.hmall.api.config.DefaultFeignConfig;
 import com.hmall.api.dto.ItemDTO;
 import com.hmall.api.dto.OrderDetailDTO;
 import org.springframework.cloud.openfeign.FeignClient;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
 import java.util.Map;

@FeignClient(value = "item-service", fallbackFactory = ItemClientFallback.class,configuration = DefaultFeignConfig.class)
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);
    @GetMapping("/items/{id}")
    ItemDTO queryItemById(@RequestParam("id") Long id);

@PutMapping("/items/stock/recover")
    void recoverStock(Map<Long, Integer> orderMap);

    @PutMapping("/items/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}
