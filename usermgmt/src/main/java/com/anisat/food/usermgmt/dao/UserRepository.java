package com.anisat.food.usermgmt.dao;

import com.anisat.food.usermgmt.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
