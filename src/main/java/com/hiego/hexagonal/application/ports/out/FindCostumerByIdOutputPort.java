package com.hiego.hexagonal.application.ports.out;

import com.hiego.hexagonal.application.core.domain.Costumer;

import java.util.Optional;

public interface FindCostumerByIdOutputPort {

    Optional<Costumer> find(String id);
}
