package com.hiego.hexagonal.config;

import com.hiego.hexagonal.adapters.out.DeleteCostumerByIdAdapter;
import com.hiego.hexagonal.adapters.out.FindCostumerByIdAdapter;
import com.hiego.hexagonal.application.core.usecase.DeleteCostumerByIdUseCase;
import com.hiego.hexagonal.application.core.usecase.FindCostumerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCostumerByIdConfig {

    @Bean
    public DeleteCostumerByIdUseCase deleteCostumerByIdUseCase(
            FindCostumerByIdUseCase findCostumerByIdUseCase,
            DeleteCostumerByIdAdapter deleteCostumerByIdAdapter
    ) {
        return new DeleteCostumerByIdUseCase(deleteCostumerByIdAdapter, findCostumerByIdUseCase);
    }
}
