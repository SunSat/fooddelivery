package com.anisat.food.usermgmt.controller.dto;

import com.anisat.food.usermgmt.dao.entity.UserType;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {

    private Long userId;
    private String userName;
    private String password;
    private String name;
    private String phone;
    private String emailId;
    private String address;
    private String place;
    private UserTypeDto userType;
    private String hotelName;
    private HotelTypeDto hotelType;
    private String bikeNo;
    private String licenseDetails;
    private String role;

}
