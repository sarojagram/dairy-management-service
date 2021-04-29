package com.agraminfotech.dairymanagement.security.role;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    private RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role saveOrUpdate(Role role){
        return  roleRepository.save(role);
    }

    public Role findById(Long id){
        return  roleRepository.findById(id).get();
    }

    public List<ApiDTO> findAllBasicInfo(){
        return roleRepository.findAllBasicInfo();
    }
}
