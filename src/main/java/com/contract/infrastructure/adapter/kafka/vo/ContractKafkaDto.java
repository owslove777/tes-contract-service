package com.contract.infrastructure.adapter.kafka.vo;

import com.contract.domain.enums.CONTRACT_STATUS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractKafkaDto {
    private Long id;
    private Long talentId;
    private Long talentItemId;
    private Long talentUserId;
    private String talentUserNm;
    private Long userId;
    private String userNm;
    private String title;
    private Long price;
    private CONTRACT_STATUS contractStatus; // BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, NOT_PERFORMED
    private String address;
}
