package com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseInfo;

import com.agraminfotech.dairymanagement.base.Model;
import com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseItem.PurchaseItem;
import com.agraminfotech.dairymanagement.security.user.User;
import com.agraminfotech.dairymanagement.vendorandCustomer.VendorAndCustomer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_info")
@Getter
@Setter
public class PurchaseInfo extends Model {

    @Column(unique = true)
    private String billNumber;

    @Column
    private BigDecimal netAmount;

    @Column
    private BigDecimal discountAmount;

    @Column
    private BigDecimal grandTotal;

    @Column(length = 5000)
    private String remarks;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date billDate;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_and_customer_id")
    private VendorAndCustomer vendorAndCustomer;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by_id")
    private User approvedBy;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "purchaseInfo", fetch = FetchType.LAZY)
    private List<PurchaseItem> purchaseItems;
}
