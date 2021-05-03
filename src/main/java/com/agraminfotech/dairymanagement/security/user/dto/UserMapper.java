package com.agraminfotech.dairymanagement.security.user.dto;

import com.agraminfotech.dairymanagement.security.user.User;
import com.agraminfotech.dairymanagement.utils.dateutils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public interface UserMapper {

    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "createdBy", source = "createdBy.username"),
            @Mapping(target = "modifiedBy", source = "modifiedBy.username")
    })
    UserDTO toDTO(User user);

    @Mappings({
            @Mapping(target = "createdBy.username", source = "createdBy"),
            @Mapping(target = "modifiedBy.username", source = "modifiedBy")
    })
    User toEntity(UserDTO userDTO);
}
