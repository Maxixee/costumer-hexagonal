package com.hiego.hexagonal.application.ports.out;

import com.hiego.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
