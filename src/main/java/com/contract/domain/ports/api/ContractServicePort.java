package com.contract.domain.ports.api;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;
import com.contract.infrastructure.adapter.kafka.vo.PaymentApprovedVo;

import java.util.List;

public interface ContractServicePort {
    List<ContractDto> findAll();

    ContractDto findById(Long id);

    List<ContractDto> findByTalentUserId(Long talentUserId);

    ContractDto save(ContractDto src);

    Boolean deleteById(Long id);

    ContractDto update(Long id, CONTRACT_STATUS state);

    List<ContractDto> findByUserId(Long userId);

    ContractDto updateContractApproved(PaymentApprovedVo paymentApprovedVo);
}
