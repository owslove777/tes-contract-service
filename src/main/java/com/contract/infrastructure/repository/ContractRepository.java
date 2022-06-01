package com.contract.infrastructure.repository;

import com.contract.infrastructure.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long>{
    
}
