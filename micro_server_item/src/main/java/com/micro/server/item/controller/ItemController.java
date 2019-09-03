package com.micro.server.item.controller;

import com.micro.server.item.entity.Item;
import com.micro.server.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxm
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    @Value("${server.port}")
    private String port;
    @Autowired
    private ItemService itemService;

    @GetMapping("/queryItemById/{id}")
    public Item queryItemById(@PathVariable Long id) {
        LOGGER.info("server port:{}", port);
        return itemService.queryItemById(id);
    }
}
