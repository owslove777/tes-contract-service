package com.contract.infrastructure.adapter.kafka;

import com.contract.domain.data.ContractDto;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContractUpdated extends AbstractKafkaEventAdapter {
    private ContractDto contractDto;
}
