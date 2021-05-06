package com.agraminfotech.dairymanagement.vendorandCustomer;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.utils.Helper;
import com.agraminfotech.dairymanagement.utils.Response;
import com.agraminfotech.dairymanagement.utils.Strings;
import com.agraminfotech.dairymanagement.utils.dateutils.DateUtils;
import com.agraminfotech.dairymanagement.vendorandCustomer.dto.VendorAndCustomerDTO;
import com.agraminfotech.dairymanagement.vendorandCustomer.dto.VendorAndCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "vendorAndCustomer/")
public class VendorAndCustomerController {

    private VendorAndCustomerService vendorAndCustomerService;

    private Helper helper;

    private VendorAndCustomerMapper vendorAndCustomerMapper;

    @Autowired
    private VendorAndCustomerController(VendorAndCustomerService vendorAndCustomerService,Helper helper,
                                        VendorAndCustomerMapper vendorAndCustomerMapper){
        this.vendorAndCustomerService = vendorAndCustomerService;
        this.helper = helper;
        this.vendorAndCustomerMapper = vendorAndCustomerMapper;
    }

    @GetMapping("findAll/basicList/ofCustomer")
    public ResponseEntity<Response> findAllBasicListOfCustomer(){
        String message = "";
        Integer statusCode = null;
        List<ApiDTO> vendorAndCustomers = null;
        try{
            vendorAndCustomers = vendorAndCustomerService.findAllActiveBasicInfoList(Strings.ACCOUNT_TYPE[2]);
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }
        return Helper.getResponseEntity(vendorAndCustomers,message,statusCode);
    }

    @GetMapping("findAll/basicList/ofVendor")
    public ResponseEntity<Response> findAllBasicListOfVendor(){
        String message = "";
        Integer statusCode = null;
        List<ApiDTO> vendorAndCustomers = null;
        try{
            vendorAndCustomers = vendorAndCustomerService.findAllActiveBasicInfoList(Strings.ACCOUNT_TYPE[1]);
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }
        return Helper.getResponseEntity(vendorAndCustomers, message, statusCode);
    }

    @GetMapping("findAll/detailsList")
    public ResponseEntity<Response> findAllDetailsListOfVendor(){
        String message = "";
        Integer statusCode = null;
        List<VendorAndCustomerDTO> vendorAndCustomers = null;
        try{
            vendorAndCustomers = vendorAndCustomerService.findAllDetailsInfoList(Strings.ACCOUNT_TYPE[0]);
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }
        return Helper.getResponseEntity(vendorAndCustomers, message, statusCode);
    }

    @PostMapping("save")
    public ResponseEntity<Response> save(@RequestBody VendorAndCustomerDTO vendorAndCustomerDTO){
        String message = "";
        Integer statusCode = null;
        try{
            if(vendorAndCustomerService.existsByEmail(vendorAndCustomerDTO.getEmail()))
                return Helper.getResponseEntity(null,Strings.EMAIL_ALREADY_EXISTS, 100);
            VendorAndCustomer vendorAndCustomer = vendorAndCustomerMapper.toEntity(vendorAndCustomerDTO);
            vendorAndCustomer.setCreatedDate(DateUtils.getCurrentDate(true));
            vendorAndCustomer.setCreatedBy(helper.getCurrentUser());
            vendorAndCustomer.setStatus(true);
            vendorAndCustomerService.saveOrUpdate(vendorAndCustomer);
            message = Strings.SAVE_SUCCESSFULLY;
            statusCode = 200;
        }catch (Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(null,message,statusCode);
    }
}
