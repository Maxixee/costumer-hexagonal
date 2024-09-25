package com.hiego.hexagonal.adapters.in.controller.response;

import com.hiego.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import lombok.Data;

@Data
public class CostumerResponse {

    private String name;
    private AddressResponseMapper address;
    private String cpf;
    private Boolean isValidCpf;
}
