package com.contract.infrastructure.adapter.kafka.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KafkaData {
    private String eventType;
    private Long timestamp;
}
