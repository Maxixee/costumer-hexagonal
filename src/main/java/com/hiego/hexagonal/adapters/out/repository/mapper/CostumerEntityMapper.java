package com.hiego.hexagonal.adapters.out.repository.mapper;

import com.hiego.hexagonal.adapters.out.repository.entity.CostumerEntity;
import com.hiego.hexagonal.application.core.domain.Costumer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CostumerEntityMapper {

    CostumerEntity toCostumerEntity(Costumer costumer);
    Costumer toCostumer(CostumerEntity costumerEntity);
}
