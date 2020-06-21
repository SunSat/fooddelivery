package com.anisat.food.usermgmt.controller;

import com.anisat.food.usermgmt.controller.dto.UserDto;
import com.anisat.food.usermgmt.convertor.UserDtoEntityConvertor;
import com.anisat.food.usermgmt.dao.UserRepository;
import com.anisat.food.usermgmt.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserMgmtController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDtoEntityConvertor userDtoEntityConvertor;

    @GetMapping(value = "api/v1/user/{id}",produces = "application/json")
    public UserDto getUserById(@PathVariable String id) {
        Optional<UserEntity> userEntity = userRepository.findById(Long.parseLong(id));
        UserDto userDto = null;
        if(userEntity.isPresent()) {
            userDto = userDtoEntityConvertor.userDaoToDto(userEntity.get());
        }
        return userDto;
    }

    @GetMapping(value = "api/v1/user")
    public List<UserDto> getAllUserList() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepository.findAll().forEach(entity -> {
            userDtos.add(userDtoEntityConvertor.userDaoToDto(entity));
        });
        return userDtos;
    }

    @PostMapping(value = "/api/v1/user")
    public boolean postNewUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userDtoEntityConvertor.userDtoToDao(userDto);
        userRepository.save(userEntity);
        return true;
    }

    @PatchMapping(value = "/api/v1/user")
    public boolean pathExistingUser(@RequestBody UserDto userDto) {
        return true;
    }
}
