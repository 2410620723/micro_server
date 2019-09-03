package com.micro.server.order.controller;

import com.micro.server.order.entity.Order;
import com.micro.server.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxm
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/queryOrderById/{id}")
    public Order queryOrderById(@PathVariable String id) {
        return orderService.queryOrderById(id);
    }

    @GetMapping("/queryOrderByIdx/{id}")
    public Order queryOrderByIdx(@PathVariable String id) {
        return orderService.queryOrderByIdx(id);
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
