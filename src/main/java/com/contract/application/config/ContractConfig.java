package com.contract.application.config;

import com.contract.domain.ports.api.ContractServiceImpl;
import com.contract.domain.ports.api.ContractServicePort;
import com.contract.domain.ports.spi.ContractPersistencePort;
import com.contract.infrastructure.adapter.jpa.ContractJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractConfig {
    @Bean
    public ContractPersistencePort contractPersistence(){
        return new ContractJpaAdapter();
    }

    @Bean
    public ContractServicePort contractService() {
        return new ContractServiceImpl(contractPersistence());
    }
}
