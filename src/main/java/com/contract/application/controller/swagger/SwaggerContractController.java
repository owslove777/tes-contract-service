package com.contract.application.controller.swagger;

import com.contract.application.controller.ContractController;
import com.contract.domain.ports.api.ContractServicePort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talent")
public class SwaggerContractController extends ContractController {
    public SwaggerContractController(ContractServicePort contractService) {
        super(contractService);
    }
}
