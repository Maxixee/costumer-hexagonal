package com.hiego.hexagonal.adapters.in.controller;

import com.hiego.hexagonal.adapters.in.controller.Request.CostumerRequest;
import com.hiego.hexagonal.adapters.in.controller.mapper.CostumerMapper;
import com.hiego.hexagonal.adapters.in.controller.response.CostumerResponse;
import com.hiego.hexagonal.application.core.domain.Costumer;
import com.hiego.hexagonal.application.ports.in.DeleteCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.in.FindCostumerByIdInputPort;
import com.hiego.hexagonal.application.ports.in.InsertCostumerInputPort;
import com.hiego.hexagonal.application.ports.in.UpdateCostumerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/costumers")
public class CostumerController {

    private InsertCostumerInputPort insertCostumerInputPort;
    private FindCostumerByIdInputPort findCostumerByIdInputPort;
    private UpdateCostumerInputPort updateCostumerInputPort;
    private DeleteCostumerByIdInputPort deleteCostumerByIdInputPort;

    @Autowired
    private CostumerMapper costumerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CostumerRequest costumerRequest){
        var costumer = costumerMapper.toCostumer(costumerRequest);
        insertCostumerInputPort.insert(costumer, costumerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostumerResponse> getById(@PathVariable String id){
        var costumer = findCostumerByIdInputPort.find(id);

        return ResponseEntity.ok()
                .body(costumerMapper.toCostumerResponse(costumer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CostumerRequest costumerRequest){
        Costumer costumer = costumerMapper.toCostumer(costumerRequest);
        costumer.setId(id);
        updateCostumerInputPort.update(costumer, costumerRequest.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCostumerByIdInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
