package com.anisat.food.ordermgnt.controller;

import com.anisat.food.ordermgnt.controller.model.OrderServiceDto;
import com.anisat.food.ordermgnt.convertor.OrderServiceConvertor;
import com.anisat.food.ordermgnt.dao.OrderServiceRepository;
import com.anisat.food.ordermgnt.dao.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class OrderServiceController {
    @Autowired
    OrderServiceRepository orderServiceRepository;

    @Autowired
    OrderServiceConvertor orderServiceConvertor;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/api/v1/order")
    public Set<OrderEntity> getAllOrders() {
        Set<OrderEntity> orderEntities =new LinkedHashSet<>();
         orderServiceRepository.findAll().forEach(entity -> orderEntities.add(entity));
         return orderEntities;
    }

    @PostMapping("/api/v1/order")
    public OrderServiceDto createNewOrder(@RequestBody OrderServiceDto orderServiceDto) {
        OrderEntity orderEntity = orderServiceConvertor.getDao(orderServiceDto);
        orderServiceRepository.save(orderEntity);
        orderServiceDto.setOrderId(orderEntity.getOrderId());
        template.send("ORDERSTATUSUPDATES",orderServiceDto);
        return orderServiceDto;
    }
}
