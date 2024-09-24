package com.hiego.hexagonal.adapters.out.repository;

import com.hiego.hexagonal.adapters.out.repository.entity.CostumerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CostumerRepository extends MongoRepository<CostumerEntity, String> {
}
