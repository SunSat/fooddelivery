package com.anisat.food.foodmgmt.dao;

import com.anisat.food.foodmgmt.dao.entity.FoodEntity;
import org.springframework.data.repository.CrudRepository;

public interface FoodServiceRepository extends CrudRepository<FoodEntity, Long> {

}
