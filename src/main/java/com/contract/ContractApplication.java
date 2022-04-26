package com.contract;

import com.contract.domain.Contract;
import com.contract.domain.Location;
import com.contract.domain.ContractRepository;
import com.contract.kafka.KafkaProcessor;

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

		Contract contract = new Contract();
		contract.setLocation(Location.판교);

		repository.save(contract);

		System.out.println(contract.getLocation());


	}

}
