package com.hiego.hexagonal.application.core.usecase;

import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.in.FindCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.in.UpdateCostumerInputPort;
import com.hiego.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hiego.hexagonal.application.ports.out.UpdateCostumerOutputPort;

public class UpdateCostumerUseCase implements UpdateCostumerInputPort {

    private final FindCostumerByIdInputPort findCostumerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCostumerOutputPort updateCostumerOutputPort;

    public UpdateCostumerUseCase(FindCostumerByIdInputPort findCostumerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCostumerOutputPort updateCostumerOutputPort) {
        this.findCostumerByIdInputPort = findCostumerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCostumerOutputPort = updateCostumerOutputPort;
    }

    @Override
    public void update(Costumer costumer, String zipCode) {
        findCostumerByIdInputPort.find(costumer.getId());
        var address =  findAddressByZipCodeOutputPort.find(zipCode);
        costumer.setAddress(address);

        updateCostumerOutputPort.update(costumer);
    }
}
