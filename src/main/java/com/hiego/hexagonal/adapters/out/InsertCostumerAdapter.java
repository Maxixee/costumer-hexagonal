package com.hiego.hexagonal.adapters.out;

import com.hiego.hexagonal.adapters.out.repository.CostumerRepository;
import com.hiego.hexagonal.adapters.out.repository.mapper.CostumerEntityMapper;
import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.out.InsertCostumerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCostumerAdapter implements InsertCostumerOutputPort {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private CostumerEntityMapper costumerEntityMapper;

    @Override
    public void insert(Costumer costumer) {
        var costumerEntity = costumerEntityMapper.toCostumerEntity(costumer);
        costumerRepository.save(costumerEntity);
    }
}
