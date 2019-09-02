package com.micro.server.item.controller;

import com.micro.server.item.entity.Item;
import com.micro.server.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ItemService itemService;

    @GetMapping("/queryItemById/{id}")
    public Item queryItemById(@PathVariable Long id) {
        return itemService.queryItemById(id);
    }
}
