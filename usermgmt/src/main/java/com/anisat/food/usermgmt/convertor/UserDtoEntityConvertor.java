package com.anisat.food.usermgmt.convertor;


import com.anisat.food.usermgmt.controller.dto.UserDto;
import com.anisat.food.usermgmt.dao.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoEntityConvertor {

    UserDto userDaoToDto(UserEntity userEntity);
    UserEntity userDtoToDao(UserDto userDto);

}
