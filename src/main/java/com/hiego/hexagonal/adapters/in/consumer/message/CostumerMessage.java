package com.hiego.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostumerMessage {

    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isValidCpf;
}
