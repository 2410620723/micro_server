package com.micro.server.order.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zxm
 */
@Component
@ConfigurationProperties(prefix = "cloud")
@Setter
@Getter
public class OrderProperties {
    private ItemProperties item = new ItemProperties();
}
