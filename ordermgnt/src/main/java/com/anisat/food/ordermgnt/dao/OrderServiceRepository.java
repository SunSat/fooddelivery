package com.anisat.food.ordermgnt.dao;

import com.anisat.food.ordermgnt.dao.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderServiceRepository extends CrudRepository<OrderEntity, Long> {

}
