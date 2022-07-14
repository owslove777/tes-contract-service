package com.contract.infrastructure.adapter.jpa;

import com.contract.domain.data.ContractDto;
import com.contract.domain.ports.spi.ContractPersistencePort;
import com.contract.infrastructure.entity.Contract;
import com.contract.infrastructure.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ContractJpaAdapter implements ContractPersistencePort {

    @Autowired
    private ContractRepository repository;

    @Override
    public List<ContractDto> findAll() {
        List<Contract> list = repository.findAll();
        return list.stream().map(Contract::toDto).collect(Collectors.toList());
    }

    @Override
    public ContractDto findById(Long id) {
        Optional<Contract> byId = repository.findById(id);
        return byId.map(Contract::toDto).orElse(null);
    }

    @Override
    public List<ContractDto> findByUserId(Long userId) {
        List<Contract> list = repository.findByUserIdOrderByRequestDateTimeDesc(userId);
        return list.stream().map(Contract::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ContractDto> findByTalentUserId(Long talentUserId) {
        List<Contract> list = repository.findByTalentUserIdOrderByRequestDateTimeDesc(talentUserId);
        return list.stream().map(Contract::toDto).collect(Collectors.toList());
    }

    @Override
    public ContractDto save(ContractDto src) {
        Contract saved = repository.save(Contract.parseFrom(src));
        return saved.toDto();
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Boolean deleteByTalentItemId(Long id) {
        repository.deleteByTalentItemId(id);
        return true;
    }
}
