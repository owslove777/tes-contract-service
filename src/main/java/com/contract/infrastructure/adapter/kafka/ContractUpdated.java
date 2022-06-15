package com.contract.infrastructure.adapter.kafka;

import com.contract.domain.data.ContractDto;
import lombok.Builder;

@Builder
public class ContractUpdated extends ContractReservedKafka {
    private ContractDto contractDto;
}
