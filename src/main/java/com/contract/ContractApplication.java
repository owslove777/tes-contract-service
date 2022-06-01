package com.contract;

import com.contract.infrastructure.adapter.kafka.KafkaProcessor;
import com.contract.infrastructure.repository.ContractRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// @RestController
@EnableAspectJAutoProxy
@EnableBinding(KafkaProcessor.class)
public class ContractApplication {

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ContractApplication.class, args);

		ContractRepository repository = applicationContext.getBean(ContractRepository.class);

	}

}
