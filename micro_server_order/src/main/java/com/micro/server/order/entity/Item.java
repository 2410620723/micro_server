package com.micro.server.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zxm
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String title;
    private String pic;
    private String desc;
    private Long price;
}
