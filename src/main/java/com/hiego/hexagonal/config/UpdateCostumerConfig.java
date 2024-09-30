package com.hiego.hexagonal.config;

import com.hiego.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.hiego.hexagonal.adapters.out.FindCostumerByIdAdapter;
import com.hiego.hexagonal.adapters.out.UpdateCostumerAdapter;
import com.hiego.hexagonal.application.core.usecase.FindCostumerByIdUseCase;
import com.hiego.hexagonal.application.core.usecase.UpdateCostumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCostumerConfig {

    @Bean
    public UpdateCostumerUseCase updateCostumerUseCase(
            FindCostumerByIdUseCase findCostumerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCostumerAdapter updateCostumerAdapter
    ) {
        return new UpdateCostumerUseCase(findCostumerByIdUseCase, findAddressByZipCodeAdapter, updateCostumerAdapter);
    }
}
