package com.agraminfotech.dairymanagement.security.role;

import com.agraminfotech.dairymanagement.base.ApiDTO;

import java.util.List;

public interface RoleDao {

    List<ApiDTO> findAllBasicInfo();
}
