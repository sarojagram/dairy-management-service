package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.product.attribute.dto.AttributeDTO;
import com.agraminfotech.dairymanagement.security.user.User;

import java.util.List;

public interface AttributeService {

    public Attribute findAttributeById(Long id);
    public boolean existAttributeByName(String name);
    public Attribute saveOrUpdate(Attribute user);
    public List<ApiDTO> findAllBasic() ;
    public List<AttributeDTO> findAttributeInfo() ;

}
