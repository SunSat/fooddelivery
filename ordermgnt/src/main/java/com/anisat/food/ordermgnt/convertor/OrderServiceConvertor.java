package com.anisat.food.ordermgnt.convertor;

import com.anisat.food.ordermgnt.controller.model.OrderServiceDto;
import com.anisat.food.ordermgnt.dao.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderServiceConvertor {

        OrderServiceDto getDto(OrderEntity orderEntity);
        OrderEntity getDao(OrderServiceDto orderServiceDto);

}
