package com.anisat.food.foodmgmt.controller.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class FoodDto {
    private Long foodId;
    private Long hotelId;
    private String name;
    private String category;
    private float rate;
    private long qty;
    private String qtyDescription;
    private float weight;
}
