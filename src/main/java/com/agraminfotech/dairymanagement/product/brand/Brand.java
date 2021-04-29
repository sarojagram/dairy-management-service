package com.agraminfotech.dairymanagement.product.brand;

import com.agraminfotech.dairymanagement.base.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
@Getter @Setter
public class Brand extends Model {

    @Column(unique = true)
    private String name;

    @Column(length = 500)
    private String remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;
}
