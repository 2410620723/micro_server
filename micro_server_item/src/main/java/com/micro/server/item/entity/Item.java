package com.micro.server.item.entity;

import lombok.*;

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
