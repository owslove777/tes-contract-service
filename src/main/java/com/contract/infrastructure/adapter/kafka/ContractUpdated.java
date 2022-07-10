package com.contract.infrastructure.adapter.kafka;

import com.contract.infrastructure.adapter.kafka.vo.ContractKafkaDto;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContractUpdated extends AbstractKafkaEventAdapter {
    private ContractKafkaDto contractDto;
}
