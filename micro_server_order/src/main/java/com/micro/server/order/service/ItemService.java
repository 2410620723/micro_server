package com.micro.server.order.service;

import com.alibaba.fastjson.JSON;
import com.micro.server.order.entity.Item;
import com.micro.server.order.properties.OrderProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxm
 */
@Service
public class ItemService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 用于替代value注解获取配置文件的url
     */
    @Autowired
    private OrderProperties orderProperties;

    /**
     * 根据id查询商品
     *
     * @param id 商品id
     * @return 返回商品信息
     */
    public Item queryItemById(Long id) {
        String itemUrl = "http://micro-server-item/item/queryItemById/{id}";
        return restTemplate.getForObject(itemUrl, Item.class, id);
    }

    /**
     * 根据id查询商品（添加容错机制）
     * @param id 商品id
     * @return 返回商品信息
     */
    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemByIdx(Long id) {
        String itemUrl = "http://micro-server-item/item/queryItemById/{id}";
        Item item = restTemplate.getForObject(itemUrl, Item.class, id);
        LOGGER.info("HystrixCommand queryItemByIdx-线程池名称:{}订单系统调用商品服务，result:{}", Thread.currentThread().getName(), JSON.toJSONString(item));
        return item;
    }

    /**
     * 请求失败执行的方法
     *
     * @param id 商品id
     * @return 返回商品的实体
     */
    private Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "查询商品信息失败", null, null, null);
    }
}
