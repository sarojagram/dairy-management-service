package com.agraminfotech.dairymanagement.vendorandCustomer;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.vendorandCustomer.dto.VendorAndCustomerDTO;

import java.util.List;

public interface VendorAndCustomerDao {

    List<ApiDTO> findAllActiveBasicInfoList(String accountType);

    List<VendorAndCustomerDTO> findAllDetailsInfoList(String accountType);

    VendorAndCustomerDTO findDetailsInfoById(Long id);
}
