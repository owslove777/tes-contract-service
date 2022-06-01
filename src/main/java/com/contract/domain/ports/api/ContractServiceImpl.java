package com.contract.domain.ports.api;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;
import com.contract.domain.ports.spi.ContractPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ContractServiceImpl implements ContractServicePort{

    private final ContractPersistencePort contractPersistence;

    @Override
    public List<ContractDto> findAll() {
        return contractPersistence.findAll();
    }

    @Override
    public ContractDto findById(Long id) {
        return contractPersistence.findById(id);
    }

    @Override
    public ContractDto save(ContractDto src) {
        return contractPersistence.save(src);
    }

    @Override
    public Boolean deleteById(Long id) {
        return contractPersistence.deleteById(id);
    }

    @Override
    public ContractDto update(Long id, CONTRACT_STATUS state) {
        ContractDto dto = findById(id);
        dto.setContractStatus(state);
        switch (state) {
            case ACCEPT_REQUESTED:
                dto.setRequestDateTime(LocalDateTime.now());
                break;
            case ACCEPTED:
                dto.setAcceptedDateTime(LocalDateTime.now());
                break;
            case REJECTED:
                dto.setRejectedDateTime(LocalDateTime.now());
                break;
            case PERFORMED:
                dto.setPerformedDateTime(LocalDateTime.now());
                break;
            case CANCELED:
                dto.setCanceledDateTime(LocalDateTime.now());
                break;
        }
        return save(dto);
    }
    /**
     *
     * BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, NOT_PERFORMED
     * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     *        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
     * 	LocalDateTime requestDateTime;
     *
     *    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
     * 	LocalDateTime acceptedDateTime;
     *
     *    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
     * 	LocalDateTime rejectedDateTime;
     *
     *    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
     * 	LocalDateTime performedDateTime;
     *
     *    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
     * 	LocalDateTime canceledDateTime;
     */
}