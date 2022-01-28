package com.shitu.controller;

import com.shitu.IDubboService;
import com.shitu.Product;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li4e
 */
@RestController
public class Controller {

    @Reference(loadbalance = "roundrobin")
    private IDubboService dubboService;

    @PostMapping("publish")
    public Product publish(@RequestParam String name) {
        Product product = new Product();
        product.setName(name);
        return dubboService.publish(product);
    }
}
