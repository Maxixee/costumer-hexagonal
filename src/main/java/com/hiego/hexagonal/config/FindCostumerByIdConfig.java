package com.hiego.hexagonal.config;

import com.hiego.hexagonal.adapters.out.FindCostumerByIdAdapter;
import com.hiego.hexagonal.application.core.usecase.FindCostumerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCostumerByIdConfig {

    @Bean
    public FindCostumerByIdUseCase findCostumerByIdUseCase(
            FindCostumerByIdAdapter findCostumerByIdAdapter
    ) {
        return new FindCostumerByIdUseCase(findCostumerByIdAdapter);
    }
}
