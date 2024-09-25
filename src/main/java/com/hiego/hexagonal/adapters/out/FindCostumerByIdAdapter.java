package com.hiego.hexagonal.adapters.out;

import com.hiego.hexagonal.adapters.out.repository.CostumerRepository;
import com.hiego.hexagonal.adapters.out.repository.mapper.CostumerEntityMapper;
import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.out.FindCostumerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCostumerByIdAdapter implements FindCostumerByIdOutputPort {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private CostumerEntityMapper costumerEntityMapper;

    @Override
    public Optional<Costumer> find(String id) {
        var costumerEntity = costumerRepository.findById(id);
        return costumerEntity.map(entity -> costumerEntityMapper.toCostumer(entity));
    }
}
