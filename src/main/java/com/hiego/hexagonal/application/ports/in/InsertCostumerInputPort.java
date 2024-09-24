package com.hiego.hexagonal.application.ports.in;

import com.hiego.hexagonal.application.core.domain.Costumer;

public interface InsertCostumerInputPort {

    void insert(Costumer costumer, String zipCode);
}
