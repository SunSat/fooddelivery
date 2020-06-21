package com.anisat.food.orchestrator.dao;

import com.anisat.food.orchestrator.dao.entity.OrderServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrchetratorRepository extends CrudRepository<OrderServiceEntity, Long> {

}
