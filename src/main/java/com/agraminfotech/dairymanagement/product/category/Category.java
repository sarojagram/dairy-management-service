package com.agraminfotech.dairymanagement.product.category;

import com.agraminfotech.dairymanagement.base.Model;
import com.agraminfotech.dairymanagement.base.ModelDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends Model {

    @Column(unique = true)
    private String name;

    @Column(length = 500)
    private String remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;
}
