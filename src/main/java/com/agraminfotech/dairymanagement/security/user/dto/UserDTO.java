package com.agraminfotech.dairymanagement.security.user.dto;

import com.agraminfotech.dairymanagement.base.ModelDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class UserDTO extends ModelDTO {

    private String firstName,middleName,lastName,phone,mobile,address,image,signature,username,password,email;

    private Collection<Long> roleIds;

    private Date birthDate;

}
