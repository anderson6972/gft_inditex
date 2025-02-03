package com.inditex.gft.infrastructure.adapter.out.persistence.mapper;

import com.inditex.gft.domain.model.Price;
import com.inditex.gft.infrastructure.adapter.out.persistence.entity.PriceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceEntityMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PriceEntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Price toDomain(PriceEntity entity) {
        return modelMapper.map(entity, Price.class);
    }

    public PriceEntity toEntity(Price domain) {
        return modelMapper.map(domain, PriceEntity.class);
    }
}
