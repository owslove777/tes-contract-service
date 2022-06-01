package com.contract.domain.ports.spi;

import com.contract.domain.data.ContractDto;

import java.util.List;

public interface ContractPersistencePort {
    List<ContractDto> findAll();

    ContractDto findById(Long id);

    ContractDto save(ContractDto src);

    Boolean deleteById(Long id);
}
