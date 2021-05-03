package com.agraminfotech.dairymanagement.security.user;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.security.user.dto.UserDTO;

import java.util.List;
public interface UserDao {

    List<ApiDTO> findAllBasic();

    List<UserDTO> findAllUserDetails();

    UserDTO findUserDetailById(Long id);

    boolean isRootUserAlreadyPresent();
}
