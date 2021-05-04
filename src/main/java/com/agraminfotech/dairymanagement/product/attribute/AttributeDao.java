package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.product.attribute.dto.AttributeDTO;

import java.util.List;

public interface AttributeDao {

    public List<ApiDTO> findAllBasic() ;

    public List<AttributeDTO> findAttributeInfo() ;
}
