package com.contract.application.controller;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;
import com.contract.domain.ports.api.ContractServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContractController {
    private final ContractServicePort contractService;

    /**
     * 모든 계약 조회
     * @return
     */
    @GetMapping("/contracts")
    public List<ContractDto> allMappings(){
        return contractService.findAll();
    }

    /**
     * id로 contract 조회
     * @param id
     * @return
     */
    @GetMapping("/contracts/{id}")
    public ContractDto findById(@PathVariable Long id){
        return contractService.findById(id);
    }


    /**
     * 신규 계약 생성
     * @param src
     * @return
     */
    @PostMapping("/contracts")
    public ContractDto createNewContract(@RequestBody ContractDto src){
        src.setId(null); // 자동 생성
        return contractService.save(src);
    }

    /**
     * 계약 상태 업데이트
     * @param id
     * @param state BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, NOT_PERFORMED
     * @return
     */
    @PutMapping("/contracts/{id}/{state}")
    public ContractDto updateContract(@PathVariable Long id, @PathVariable CONTRACT_STATUS state){
        return contractService.update(id, state);
    }

    /**
     * 계약 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/contracts/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return contractService.deleteById(id);
    }
}
