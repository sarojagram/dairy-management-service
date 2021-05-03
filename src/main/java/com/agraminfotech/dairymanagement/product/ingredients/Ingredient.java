package com.agraminfotech.dairymanagement.product.ingredients;

import com.agraminfotech.dairymanagement.product.measurement.Measurement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(length =  500)
    private String remarks;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;
}
