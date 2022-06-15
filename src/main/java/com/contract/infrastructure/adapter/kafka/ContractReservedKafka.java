package com.contract.infrastructure.adapter.kafka;

import com.contract.domain.data.ContractDto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractReservedKafka extends AbstractKafkaEventAdapter {
    private ContractDto contractDto;
}
