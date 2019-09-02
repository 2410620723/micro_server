package com.micro.server.order.service;

import com.micro.server.order.entity.Item;
import com.micro.server.order.entity.Order;
import com.micro.server.order.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 订单service
 *
 * @author zxm
 */
@Service
public class OrderService {
    private final static Map<String, Order> ORDER_DATA = new HashMap<>(16);
    static {
        Order order = new Order();
        order.setOrderId("20190831123203");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetails = new ArrayList<>();
        // 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
        Item item = new Item();
        item.setId(1L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));
        // 构造第二个商品数据
        item = new Item();
        item.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        order.setOrderDetails(orderDetails);
        ORDER_DATA.put(order.getOrderId(), order);
    }

    @Autowired
    private ItemService itemService;

    /**
     * 根据订单Id获取订单
     * @param orderId 订单id
     * @return
     */
    public Order queryOrderById(String orderId) {
        Order order = ORDER_DATA.get(orderId);
        if (order == null) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        orderDetails.forEach(o -> {
            Item item = itemService.queryItemById(o.getItem().getId());
            if (item == null) {
                return;
            }
            o.setItem(item);
        });
        return order;
    }

}
