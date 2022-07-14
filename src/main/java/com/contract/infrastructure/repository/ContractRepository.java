package com.contract.infrastructure.repository;

import com.contract.infrastructure.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long>{

    List<Contract> findByUserIdOrderByRequestDateTimeDesc(Long userId);
    List<Contract> findByTalentUserIdOrderByRequestDateTimeDesc(Long talentUserId);

    void deleteByTalentItemId(Long id);
}
