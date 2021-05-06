package com.agraminfotech.dairymanagement.product.attribute.dto;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.product.attribute.Attribute;
import com.agraminfotech.dairymanagement.product.attribute.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping(value = "/basic-info")
    public List<ApiDTO> findAllBasicInfo(){
        return attributeService.findAllBasic();
    }

    @GetMapping(value = "/info")
    public List<AttributeDTO> findAttributeInfo(){
        return attributeService.findAttributeInfo();
    }

    @GetMapping(value = "/find-by-id/{id}")
    public Attribute findAttributeById(@PathVariable("id") Long id){
        return attributeService.findAttributeById(id);
    }

    @GetMapping(value = "/exist-by-name/{name}")
    public boolean existAttributeByName(@PathVariable("name") String name){
        return attributeService.existAttributeByName(name);
    }

    @PostMapping(value="/")
    public Attribute saveAttribute(@RequestBody Attribute attribute){
        return attributeService.saveOrUpdate(attribute);
    }

    @PutMapping(value="/")
    public Attribute updateAttribute(@RequestBody Attribute attribute){
        return attributeService.saveOrUpdate(attribute);
    }
}
