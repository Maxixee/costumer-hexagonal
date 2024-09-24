package com.hiego.hexagonal.application.core.usecase;

import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.in.InsertCostumerInputPort;
import com.hiego.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hiego.hexagonal.application.ports.out.InsertCostumerOutputPort;

public class InsertCostumerUseCase implements InsertCostumerInputPort {
    //usecase é basicamente o Service

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCostumerOutputPort insertCostumerOutputPort;

    public InsertCostumerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCostumerOutputPort insertCostumerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCostumerOutputPort = insertCostumerOutputPort;
    }

    @Override
    public void insert(Costumer costumer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        costumer.setAddress(address);
        insertCostumerOutputPort.insert(costumer);
    }
}
