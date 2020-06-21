package com.anisat.food.foodmgmt.dao.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;
    private Long hotelId;
    private String name;
    private String category;
    private float rate;
    private long qty;
    private String qtyDescription;
    private float weight;
    
}
