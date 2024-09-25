package com.hiego.hexagonal.application.core.usecase;

import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.in.FindCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.out.FindCostumerByIdOutputPort;

public class FindCostumerByIdUseCase implements FindCostumerByIdInputPort {

    private final FindCostumerByIdOutputPort findCostumerByIdOutputPort;

    public FindCostumerByIdUseCase(FindCostumerByIdOutputPort findCostumerByIdOutputPort){
        this.findCostumerByIdOutputPort = findCostumerByIdOutputPort;
    }

    @Override
    public Costumer find(String id) {
        return findCostumerByIdOutputPort.find(id).orElseThrow(
                ()-> new RuntimeException("Costumer not found")
        );
    }
}
