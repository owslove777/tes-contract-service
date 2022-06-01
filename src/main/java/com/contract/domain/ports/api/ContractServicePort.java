package com.contract.domain.ports.api;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;

import java.util.List;

public interface ContractServicePort {
    List<ContractDto> findAll();

    ContractDto findById(Long id);

    ContractDto save(ContractDto src);

    Boolean deleteById(Long id);

    ContractDto update(Long id, CONTRACT_STATUS state);
}
