package com.agraminfotech.dairymanagement.base;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class ModelDTO {

    private BigInteger id;

    private String name,createdBy,modifiedBy;

    private Date createdDate, modifiedDate;
}
