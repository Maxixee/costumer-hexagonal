package com.hiego.hexagonal.application.core.usecase;

import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.in.InsertCostumerInputPort;
import com.hiego.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hiego.hexagonal.application.ports.out.InsertCostumerOutputPort;
import com.hiego.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCostumerUseCase implements InsertCostumerInputPort {
    //usecase é basicamente o Service

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCostumerOutputPort insertCostumerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCostumerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCostumerOutputPort insertCostumerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCostumerOutputPort = insertCostumerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Costumer costumer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        costumer.setAddress(address);
        insertCostumerOutputPort.insert(costumer);
        sendCpfForValidationOutputPort.send(costumer.getCpf());
    }
}
