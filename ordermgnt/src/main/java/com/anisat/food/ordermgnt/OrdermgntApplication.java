package com.anisat.food.ordermgnt;

import com.anisat.food.ordermgnt.dao.OrderServiceRepository;
import com.anisat.food.ordermgnt.dao.entity.OrderEntity;
import com.anisat.food.ordermgnt.dao.entity.OrderStatusEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@Log4j2
public class OrdermgntApplication {



    public static void main(String[] args) {
        SpringApplication.run(OrdermgntApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrderServiceRepository orderServiceRepository) {
        return (args) -> {

            OrderEntity orderEntity = new OrderEntity(null,1l,1l,200.0f,OrderStatusEntity.CREATED,"delivery address",1l,2l);
            orderServiceRepository.save(orderEntity);

            for(OrderEntity orderEn : orderServiceRepository.findAll()) {
                log.info(orderEn);
            }

        };
    }

}
