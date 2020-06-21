package com.anisat.food.orchestrator.convertor;


import com.anisat.food.orchestrator.controller.model.OrderServiceDto;
import org.mapstruct.Mapper;
import com.anisat.food.orchestrator.dao.entity.*;
@Mapper
public interface OrchestratorConvertor {
    OrderServiceDto fromOrderServiceDaoToDto(OrderServiceEntity orderEntity);
    OrderServiceEntity fromOrderServiceDtoToDao (OrderServiceDto orderServiceDto );
}
