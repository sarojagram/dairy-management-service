package com.agraminfotech.dairymanagement.vendorandCustomer.dto;

import com.agraminfotech.dairymanagement.vendorandCustomer.VendorAndCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorAndCustomerMapper {

    VendorAndCustomerMapper vendorAndCustomerMapper = Mappers.getMapper(VendorAndCustomerMapper.class);

    @Mappings({
        @Mapping(target = "createdBy", source = "createdBy.username"),
        @Mapping(target = "modifiedBy", source = "modifiedBy.username")
    })

    VendorAndCustomerDTO toDTO(VendorAndCustomerMapper vendorAndCustomerMapper);

    @Mappings({
        @Mapping(target = "createdBy.username", source = "createdBy"),
        @Mapping(target = "modifiedBy.username", source = "modifiedBy")
    })
    VendorAndCustomer toEntity(VendorAndCustomerDTO vendorAndCustomerDTO);
}
