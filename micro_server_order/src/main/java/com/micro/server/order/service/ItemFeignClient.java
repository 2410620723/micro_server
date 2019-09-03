package com.micro.server.order.service;

import com.micro.server.order.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zxm
 */
@FeignClient(value = "micro-server-item", fallback = ItemServiceFallback.class)
public interface ItemFeignClient {
    /**
     * 根据id查询商品
     *
     * @param id 商品id
     * @return 返回商品信息
     */
    @GetMapping("/item/queryItemById/{id}")
    Item queryItemById(@PathVariable Long id);
}
