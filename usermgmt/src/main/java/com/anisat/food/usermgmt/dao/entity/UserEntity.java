package com.anisat.food.usermgmt.dao.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private String name;
    private String phone;
    private String emailId;
    private String address;
    private String place;
    private UserType userType;
    private String hotelName;
    private HotelType hotelType;
    private String bikeNo;
    private String licenseDetails;
    private String role;
}
