package com.hiego.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "costumers")
public class CostumerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isCpfValid;
}
