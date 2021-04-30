package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.Model;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
@Getter @Setter
public class Attribute extends Model {

    @Column(unique = true)
    private String name;

    @Column
    private String value;

    @Column(length = 500)
    private String remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;
}
