package com.agraminfotech.dairymanagement.product.attribute.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class AttributeDTO {

    private String name, value, remarks, status, createdBy, modifiedBy;

    private BigInteger id;

    private Date createdDate, modifiedDate;
}
