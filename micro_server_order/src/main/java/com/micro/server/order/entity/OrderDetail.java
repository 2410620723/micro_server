package com.micro.server.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 订单详情
 *
 * @author zxm
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {
    private String orderId;
    private Item item = new Item();
}
