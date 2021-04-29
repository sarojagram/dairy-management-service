package com.agraminfotech.dairymanagement.product.measurement;

import com.agraminfotech.dairymanagement.base.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "measurement")
@Getter @Setter
public class Measurement extends Model {

    @Column(unique = true)
    private String name;

    @Column(length = 500)
    private String Remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;
}
