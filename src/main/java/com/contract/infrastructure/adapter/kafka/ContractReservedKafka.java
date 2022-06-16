package com.contract.infrastructure.adapter.kafka;

import com.contract.domain.data.ContractDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractReservedKafka extends AbstractKafkaEventAdapter {
    private ContractDto contractDto;
}
