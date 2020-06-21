package com.anisat.food.usermgmt;

import com.anisat.food.usermgmt.controller.dto.HotelTypeDto;
import com.anisat.food.usermgmt.dao.UserRepository;
import com.anisat.food.usermgmt.dao.entity.HotelType;
import com.anisat.food.usermgmt.dao.entity.UserEntity;
import com.anisat.food.usermgmt.dao.entity.UserType;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@Log4j2
public class UsermgmtApplication {


    public static void main(String[] args) {
        SpringApplication.run(UsermgmtApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            //Save New Customer 1.
            repository.save(new UserEntity(null,"satunar","hello@123",
                    "Sathish Kumar","918754408431", "sundar.sat84@gmail.com",
                    "chinna kulam street","ramapuram",UserType.CUSTOMER,null,null,null,
                    null,"user"));

            repository.save(new UserEntity(null,"sathish","hello@123",
                    "Kumar","87689098789", "lksdjflksfjsdlkj84@gmail.com",
                    "chinna kulam street","ramapuram",UserType.CUSTOMER,null,null,null,
                    null,"user"));

            repository.save(new UserEntity(null,"asdfsadf","asdfds",
                    "sdfsd","234565432", "sdfgrd@gmail.com",
                    "chinna kulam street","ramapuram",UserType.HOTEL,"Saravana Bhavan", HotelType.PUREVEG,null,
                    null,"user"));

            repository.save(new UserEntity(null,"2345","123456",
                    "sdfsd","234565432", "sdfgrd@gmail.com",
                    "chinna kulam street","ramapuram",UserType.HOTEL,"Bhurai", HotelType.NONVEG,null,
                    null,"user"));

            repository.save(new UserEntity(null,"2345","123456",
                    "sdfsd","234565432", "sdfgrd@gmail.com",
                    "chinna kulam street","ramapuram",UserType.DELIVERY,null, null,"TN24-X2670",
                    "12345321234","user"));

            repository.save(new UserEntity(null,"2345","123456",
                    "sdfsd","234565432", "sdfgrd@gmail.com",
                    "chinna kulam street","ramapuram",UserType.DELIVERY,null, null,"TN24-X56789",
                    "12345321234","user"));

            for(UserEntity user : repository.findAll()) {
                log.info(user);
            }

            Optional<UserEntity> optional = repository.findById(1l);
            UserEntity entity = null;
            if(optional.isPresent()) {
                entity = optional.get();
            }
            log.info(entity);

        };
    }

}
