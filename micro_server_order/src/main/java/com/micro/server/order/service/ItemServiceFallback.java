package com.micro.server.order.service;

import com.micro.server.order.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 回调类
 * 此类中的方法专门用于服务降级，该类一般要实现调用远程服务的接口（这样保证方法名一致）
 *
 * @author zxm
 */
@Component
public class ItemServiceFallback implements ItemFeignClient {
    @Override
    public Item queryItemById(@PathVariable Long id) {
        return new Item(id, "查询商品出错", null, null, null);
    }
}
