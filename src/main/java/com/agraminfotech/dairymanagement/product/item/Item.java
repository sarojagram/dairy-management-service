package com.agraminfotech.dairymanagement.product.item;

import com.agraminfotech.dairymanagement.base.Model;
import com.agraminfotech.dairymanagement.product.attribute.Attribute;
import com.agraminfotech.dairymanagement.product.category.Category;
import com.agraminfotech.dairymanagement.product.measurement.Measurement;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item extends Model {

    @Column(unique = true)
    private String code;

    private String name;

    private String imageUrl;

    private BigDecimal purchasePrice;

    private BigDecimal sellingPrice;

    @ManyToOne
    private Measurement measurement;

    @ManyToOne
    private Category productCategory;

    @OneToMany(targetEntity = Attribute.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<Attribute> productAttributes = new ArrayList<>();

    @Column(length = 5000)
    private String description;

    @Column(length = 500)
    private String remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;
}
