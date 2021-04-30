package com.agraminfotech.dairymanagement.security.user.dto;

import com.agraminfotech.dairymanagement.security.user.User;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T11:16:57+0545",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreatedBy( userCreatedByUsername( user ) );
        userDTO.setModifiedBy( userModifiedByUsername( user ) );
        if ( user.getId() != null ) {
            userDTO.setId( BigInteger.valueOf( user.getId() ) );
        }
        if ( user.getCreatedDate() != null ) {
            userDTO.setCreatedDate( new SimpleDateFormat().format( user.getCreatedDate() ) );
        }
        if ( user.getModifiedDate() != null ) {
            userDTO.setModifiedDate( new SimpleDateFormat().format( user.getModifiedDate() ) );
        }
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setMiddleName( user.getMiddleName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setMobile( user.getMobile() );
        userDTO.setAddress( user.getAddress() );
        userDTO.setImage( user.getImage() );
        userDTO.setSignature( user.getSignature() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setBirthDate( user.getBirthDate() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setCreatedBy( userDTOToUser( userDTO ) );
        user.setModifiedBy( userDTOToUser1( userDTO ) );
        if ( userDTO.getId() != null ) {
            user.setId( userDTO.getId().longValue() );
        }
        user.setFirstName( userDTO.getFirstName() );
        user.setMiddleName( userDTO.getMiddleName() );
        user.setLastName( userDTO.getLastName() );
        user.setBirthDate( userDTO.getBirthDate() );
        user.setAddress( userDTO.getAddress() );
        user.setPhone( userDTO.getPhone() );
        user.setMobile( userDTO.getMobile() );
        user.setUsername( userDTO.getUsername() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setImage( userDTO.getImage() );
        user.setSignature( userDTO.getSignature() );
        try {
            if ( userDTO.getCreatedDate() != null ) {
                user.setCreatedDate( new SimpleDateFormat().parse( userDTO.getCreatedDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( userDTO.getModifiedDate() != null ) {
                user.setModifiedDate( new SimpleDateFormat().parse( userDTO.getModifiedDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return user;
    }

    private String userCreatedByUsername(User user) {
        if ( user == null ) {
            return null;
        }
        User createdBy = user.getCreatedBy();
        if ( createdBy == null ) {
            return null;
        }
        String username = createdBy.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String userModifiedByUsername(User user) {
        if ( user == null ) {
            return null;
        }
        User modifiedBy = user.getModifiedBy();
        if ( modifiedBy == null ) {
            return null;
        }
        String username = modifiedBy.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getCreatedBy() );

        return user;
    }

    protected User userDTOToUser1(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getModifiedBy() );

        return user;
    }
}
