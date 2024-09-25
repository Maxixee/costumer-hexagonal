package com.hiego.hexagonal.adapters.out;

import com.hiego.hexagonal.adapters.out.repository.CostumerRepository;
import com.hiego.hexagonal.application.ports.out.DeleteCostumerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCostumerByIdAdapter implements DeleteCostumerByIdOutputPort {

    @Autowired
    private CostumerRepository costumerRepository;

    @Override
    public void delete(String id) {
        costumerRepository.deleteById(id);
    }
}
