package com.hiego.hexagonal.application.ports.out;

import com.hiego.hexagonal.application.core.domain.Costumer;

public interface InsertCostumerOutputPort {

    void insert(Costumer costumer);
}
