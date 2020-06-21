package com.anisat.food.ordermgnt.controller.model;

import com.anisat.food.ordermgnt.dao.entity.OrderStatusEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
