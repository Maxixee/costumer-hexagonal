package com.hiego.hexagonal.application.core.usecase;

import com.hiego.hexagonal.application.ports.in.DeleteCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.in.FindCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.out.DeleteCostumerByIdOutputPort;

public class DeleteCostumerByIdUseCase implements DeleteCostumerByIdInputPort {

    private final FindCostumerByIdInputPort findCostumerByIdInputPort;
    private final DeleteCostumerByIdOutputPort deleteCostumerByIdOutputPort;

    public DeleteCostumerByIdUseCase(DeleteCostumerByIdOutputPort deleteCostumerByIdOutputPort,
                                     FindCostumerByIdInputPort findCostumerByIdInputPort) {
        this.deleteCostumerByIdOutputPort = deleteCostumerByIdOutputPort;
        this.findCostumerByIdInputPort = findCostumerByIdInputPort;
    }

    @Override
    public void delete(String id) {
        findCostumerByIdInputPort.find(id);
        deleteCostumerByIdOutputPort.delete(id);
    }
}
