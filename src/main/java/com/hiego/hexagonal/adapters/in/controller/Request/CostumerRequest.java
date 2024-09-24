package com.hiego.hexagonal.adapters.in.controller.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CostumerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;
}
