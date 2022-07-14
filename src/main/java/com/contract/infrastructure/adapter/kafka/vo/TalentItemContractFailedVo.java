package com.contract.infrastructure.adapter.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentItemContractFailedVo extends KafkaData {
    private ContractKafkaDto contractDto;
}
