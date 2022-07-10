package com.contract.infrastructure.adapter.kafka;

import com.contract.infrastructure.adapter.kafka.vo.ContractKafkaDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractReservedKafka extends AbstractKafkaEventAdapter {
    private ContractKafkaDto contractDto;
}
