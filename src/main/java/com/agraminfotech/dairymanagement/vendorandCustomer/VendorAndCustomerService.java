package com.agraminfotech.dairymanagement.vendorandCustomer;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.vendorandCustomer.dto.VendorAndCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorAndCustomerService {

    private VendorAndCustomerRepository vendorAndCustomerRepository;

    @Autowired
    private VendorAndCustomerService(VendorAndCustomerRepository vendorAndCustomerRepository){
        this.vendorAndCustomerRepository = vendorAndCustomerRepository;
    }

    public VendorAndCustomer saveOrUpdate(VendorAndCustomer vendorAndCustomer){
        return  vendorAndCustomerRepository.save(vendorAndCustomer);
    }

    public VendorAndCustomer findById(Long id){
        if(vendorAndCustomerRepository.findById(id).isPresent())
        return  vendorAndCustomerRepository.findById(id).get();
        else return  null;
    }

    public List<ApiDTO> findAllActiveBasicInfoList(String accountType) {
        return  vendorAndCustomerRepository.findAllActiveBasicInfoList(accountType);
    }

    public List<VendorAndCustomerDTO> findAllDetailsInfoList(String accountType) {
        return vendorAndCustomerRepository.findAllDetailsInfoList(accountType);
    }

    public VendorAndCustomerDTO findDetailsInfoById(Long id) {
        return vendorAndCustomerRepository.findDetailsInfoById(id);
    }

    public  boolean existsByEmail(String email){
        return vendorAndCustomerRepository.existsByEmail(email);
    }

}
