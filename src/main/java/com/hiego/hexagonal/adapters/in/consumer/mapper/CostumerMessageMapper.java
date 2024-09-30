package com.hiego.hexagonal.adapters.in.consumer.mapper;

import com.hiego.hexagonal.adapters.in.consumer.message.CostumerMessage;
import com.hiego.hexagonal.application.core.domain.Costumer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostumerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Costumer toCostumer(CostumerMessage costumerMessage);
}
