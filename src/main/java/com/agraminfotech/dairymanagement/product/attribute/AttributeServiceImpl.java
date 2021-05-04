package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.product.attribute.dto.AttributeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public Attribute findAttributeById(Long id) {
        return attributeRepository.findById(id).get();
    }

    @Override
    public boolean existAttributeByName(String name) {
        return attributeRepository.existsByName(name);
    }

    @Override
    public Attribute saveOrUpdate(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public List<ApiDTO> findAllBasic() {
        return attributeRepository.findAllBasic();
    }

    @Override
    public List<AttributeDTO> findAttributeInfo() {
        return attributeRepository.findAttributeInfo();
    }
}
