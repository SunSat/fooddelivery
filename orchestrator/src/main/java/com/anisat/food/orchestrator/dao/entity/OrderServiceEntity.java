package com.anisat.food.orchestrator.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ordreEntity")
public class OrderServiceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "restaruntId")
    private Long restaruntId;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "status")
    private OrderTypeServiceEntity overAllStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "foodId")
    private Long foodId;

    @Column(name = "qty")
    private Long   qty;
}
