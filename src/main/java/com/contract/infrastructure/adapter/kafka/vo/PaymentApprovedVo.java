package com.contract.infrastructure.adapter.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentApprovedVo extends KafkaData {
    private Long amount;
    private Long contractId;
}
