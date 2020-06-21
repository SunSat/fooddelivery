package com.anisat.food.orchestrator.controller.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceDto {

    private Long orderId;

    private Long userId;

    private Long restaruntId;

    private Float cost;

    private OrderStatusDto overAllStatus;

    private String address;

    private Long foodId;

    private Long   qty;
}
