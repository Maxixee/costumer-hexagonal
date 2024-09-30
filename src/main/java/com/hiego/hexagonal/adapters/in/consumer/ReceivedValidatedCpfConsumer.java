package com.hiego.hexagonal.adapters.in.consumer;

import com.hiego.hexagonal.adapters.in.consumer.mapper.CostumerMessageMapper;
import com.hiego.hexagonal.adapters.in.consumer.message.CostumerMessage;
import com.hiego.hexagonal.application.ports.in.UpdateCostumerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceivedValidatedCpfConsumer {

    @Autowired
    private UpdateCostumerInputPort updateCostumerInputPort;

    @Autowired
    private CostumerMessageMapper costumerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hexagonal")
    public void receive(CostumerMessage costumerMessage) {
        var costumer = costumerMessageMapper.toCostumer(costumerMessage);
        updateCostumerInputPort.update(costumer, costumerMessage.getZipCode());
    }
}
