package com.agraminfotech.dairymanagement.vendorandCustomer.dto;

import com.agraminfotech.dairymanagement.base.ModelDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorAndCustomerDTO extends ModelDTO {

    private String email,address,phone,mobile,accountType;

    private boolean status;

}
