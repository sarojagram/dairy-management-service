package com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseItem;

import com.agraminfotech.dairymanagement.product.measurement.Measurement;
import com.agraminfotech.dairymanagement.product.rawmaterial.RawMaterial;
import com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseInfo.PurchaseInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_item")
@Getter
@Setter
public class PurchaseItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private BigDecimal rate;

    @Column
    private Float quantity;

    @Column
    private BigDecimal amount;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raw_material-id")
    private RawMaterial rawMaterial;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "measurement_id")
    private Measurement measurement;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_info_id")
    private PurchaseInfo purchaseInfo;
}
