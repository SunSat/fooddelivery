package com.anisat.food.orchestrator.kafka;

import com.anisat.food.orchestrator.controller.model.OrderServiceDto;
import com.anisat.food.orchestrator.convertor.OrchestratorConvertor;
import com.anisat.food.orchestrator.dao.OrchetratorRepository;
import com.anisat.food.orchestrator.dao.entity.OrderServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    OrchetratorRepository orchetratorRepository;

    @Autowired
    OrchestratorConvertor orchestratorConvertor;

    @KafkaListener(topics = "ORDERSTATUSUPDATES",groupId = "ORDERSTATUSUPDATES")
    public void orderMessageReceived(OrderServiceDto orderServiceDto) {
        OrderServiceEntity entity = orchestratorConvertor.fromOrderServiceDtoToDao(orderServiceDto);
        orchetratorRepository.save(entity);
    }

}
