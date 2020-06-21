package com.anisat.food.foodmgmt;

import com.anisat.food.foodmgmt.dao.FoodServiceRepository;
import com.anisat.food.foodmgmt.dao.entity.FoodEntity;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@Log4j2
public class FoodmgmtApplication {


    public static void main(String[] args) {
        SpringApplication.run(FoodmgmtApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(FoodServiceRepository repository) {
        return (args) -> {

            //Save New Customer 1.
            repository.save(new FoodEntity(null,3l,"itly", "veg",20.0f, 1,
                    "1 Plate contains 2 Nos.",200.0f));

            repository.save(new FoodEntity(null,3l,"chapathi", "veg",30.0f, 1,
                    "1 Plate contains 2 Nos.",300.0f));

            repository.save(new FoodEntity(null,3l,"meal", "veg",100.0f, 1,
                    "1 Parcel. Contains rice, sambar, poriyal, papad.",600.0f));

            repository.save(new FoodEntity(null,4l,"meal", "nonveg",200.0f, 1,
                    "1 Parcel. Contains rice, checken kolambu, poriyal, papad.",600.0f));

            repository.save(new FoodEntity(null,4l,"checken keema dosai", "nonveg",150.0f, 1,
                    "1 No.",200.0f));

            repository.save(new FoodEntity(null,4l,"podi itly", "nonveg",80.0f, 1,
                    "2 No. Sidish : Chicken Kurma.",200.0f));


            for(FoodEntity user : repository.findAll()) {
                log.info(user);
            }

            Optional<FoodEntity> optional = repository.findById(1l);
            FoodEntity entity = null;
            if(optional.isPresent()) {
                entity = optional.get();
            }
            log.info(entity);

        };
    }

}
