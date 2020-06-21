package com.anisat.food.foodmgmt.convertor;

import com.anisat.food.foodmgmt.controller.model.FoodDto;
import com.anisat.food.foodmgmt.dao.entity.FoodEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FoodServiceConvertor {

        public FoodDto fromFoodDaoToDto(FoodEntity foodEntity);
        public FoodEntity fromDtoToEntity(FoodDto foodDto);

}
