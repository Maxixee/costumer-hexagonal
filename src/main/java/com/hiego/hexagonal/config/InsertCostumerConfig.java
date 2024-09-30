package com.hiego.hexagonal.config;

import com.hiego.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.hiego.hexagonal.adapters.out.InsertCostumerAdapter;
import com.hiego.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.hiego.hexagonal.application.core.usecase.InsertCostumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCostumerConfig {

    @Bean
    public InsertCostumerUseCase insertCostumerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCostumerAdapter insertCostumerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCostumerUseCase(findAddressByZipCodeAdapter, insertCostumerAdapter, sendCpfValidationAdapter);
    }
}
