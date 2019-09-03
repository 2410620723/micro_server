package com.micro.server.test;

import com.micro.server.order.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zxm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItemServerTest.class)
@Import(OrderApplication.class)
public class ItemServerTest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        String serviceId = "micro-server-item";
        for (int i = 0; i < 100; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
        }
    }
}
