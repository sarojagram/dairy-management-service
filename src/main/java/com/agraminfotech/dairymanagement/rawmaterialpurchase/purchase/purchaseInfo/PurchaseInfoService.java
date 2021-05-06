package com.agraminfotech.dairymanagement.rawmaterialpurchase.purchase.purchaseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseInfoService {

    private PurchaseInfoRepository purchaseInfoRepository;

    @Autowired
    private PurchaseInfoService(PurchaseInfoRepository purchaseInfoRepository){
        this.purchaseInfoRepository = purchaseInfoRepository;
    }

    public PurchaseInfo saveOrUpdate(PurchaseInfo purchaseInfo){
        return  purchaseInfoRepository.save(purchaseInfo);
    }
}
