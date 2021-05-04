package com.agraminfotech.dairymanagement.security.user.dto;

import com.agraminfotech.dairymanagement.base.ModelDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class UserDTO extends ModelDTO {

    private String firstName,middleName,lastName,phone,mobile,address,image,
            signature,username,password,oldPassword,email;

    private Collection<Long> roleIds;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    boolean enabled;

}
