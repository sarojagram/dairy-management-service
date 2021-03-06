package com.agraminfotech.dairymanagement.product.item;

import com.agraminfotech.dairymanagement.base.Model;
import com.agraminfotech.dairymanagement.product.attribute.Attribute;
import com.agraminfotech.dairymanagement.product.brand.Brand;
import com.agraminfotech.dairymanagement.product.category.Category;
import com.agraminfotech.dairymanagement.product.ingredients.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String imageUrl;

    @Column
    private BigDecimal purchasePrice;

    @Column(length = 5000)
    private String description;

    @Column(length = 500)
    private String remarks;

    @Column(columnDefinition = "boolean default 1")
    private boolean status;

    @Column(columnDefinition = "boolean default 0")
    private boolean deletedStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private Category productCategory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @JsonIgnore
    @OneToMany(targetEntity = Attribute.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<Attribute> productAttributes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = Attribute.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<Ingredient> Ingredients = new ArrayList<>();

}
