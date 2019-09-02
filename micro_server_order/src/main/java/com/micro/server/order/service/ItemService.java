package com.micro.server.order.service;

import com.micro.server.order.entity.Item;
import com.micro.server.order.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxm
 */
@Service
public class ItemService {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 用于替代value注解获取配置文件的url
     */
    @Autowired
    private OrderProperties orderProperties;

    public Item queryItemById(Long id) {
        String itemUrl = "http://micro-server-item/item/queryItemById/{id}";
        return restTemplate.getForObject(itemUrl, Item.class, id);
    }
}
