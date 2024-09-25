package com.hiego.hexagonal.application.ports.in;

import com.hiego.hexagonal.application.core.domain.Costumer;

public interface FindCostumerByIdInputPort {

    Costumer find(String id);
}
