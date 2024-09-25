package com.hiego.hexagonal.application.ports.out;

import com.hiego.hexagonal.application.core.domain.Costumer;

public interface UpdateCostumerOutputPort {

    void update(Costumer costumer);
}
