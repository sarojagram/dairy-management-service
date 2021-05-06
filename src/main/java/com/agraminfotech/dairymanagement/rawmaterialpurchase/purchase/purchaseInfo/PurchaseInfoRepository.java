package com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInfoRepository extends JpaRepository<PurchaseInfo, Long> {

}
