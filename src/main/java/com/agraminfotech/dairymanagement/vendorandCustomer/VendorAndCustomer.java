package com.agraminfotech.dairymanagement.vendorandCustomer;

import com.agraminfotech.dairymanagement.base.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_and_customer")
@Getter
@Setter
public class VendorAndCustomer extends Model {

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    private String mobile;

    @Column
    private String address;

    @Column
    private String accountType;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;

}
