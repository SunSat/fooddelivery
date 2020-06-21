package com.anisat.food.foodmgmt.controller;

import com.anisat.food.foodmgmt.controller.model.FoodDto;
import com.anisat.food.foodmgmt.convertor.FoodServiceConvertor;
import com.anisat.food.foodmgmt.dao.FoodServiceRepository;
import com.anisat.food.foodmgmt.dao.entity.FoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FoodServiceController {
    @Autowired
    FoodServiceRepository foodServiceRepository;

    @Autowired
    FoodServiceConvertor foodServiceConvertor;

    @GetMapping(value = "api/v1/food/{id}",produces = "application/json")
    public FoodDto getUserById(@PathVariable String id) {
        Optional<FoodEntity> userEntity = foodServiceRepository.findById(Long.parseLong(id));
        FoodDto userDto = null;
        if(userEntity.isPresent()) {
            userDto = foodServiceConvertor.fromFoodDaoToDto(userEntity.get());
        }
        return userDto;
    }

    @GetMapping(value = "api/v1/food", produces = "application/json")
    public List<FoodDto> getAllUserList() {
        List<FoodDto> userDtos = new ArrayList<>();
        foodServiceRepository.findAll().forEach(entity -> {
            userDtos.add(foodServiceConvertor.fromFoodDaoToDto(entity));
        });
        return userDtos;
    }

    @PostMapping(value = "/api/v1/food", produces = "application/json")
    public boolean postNewUser(@RequestBody FoodDto userDto) {
        FoodEntity userEntity = foodServiceConvertor.fromDtoToEntity(userDto);
        foodServiceRepository.save(userEntity);
        return true;
    }
}
