package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.Model;
import com.agraminfotech.dairymanagement.product.measurement.Measurement;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attribute")
@Getter @Setter
public class Attribute extends Model implements Serializable {

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
