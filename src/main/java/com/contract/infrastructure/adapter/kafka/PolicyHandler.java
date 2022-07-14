package com.contract.infrastructure.adapter.kafka;

import com.contract.domain.data.ContractDto;
import com.contract.domain.ports.api.ContractServicePort;
import com.contract.infrastructure.adapter.kafka.vo.ContractKafkaDto;
import com.contract.infrastructure.adapter.kafka.vo.PaymentApprovedVo;
import com.contract.infrastructure.adapter.kafka.vo.TalentItemContractFailedVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolicyHandler {

    private final ContractServicePort contractService;
    private ObjectMapper mapper = new ObjectMapper();

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){
        Map<String, String> map = parseToMap(eventString);
        if (map == null) {
        return;
    }

        switch (map.get("eventType")) {
        case "PaymentApproved": // 결제 완료
            log.info("## 결제 완료");
            PaymentApprovedVo paymentApprovedVo = parseToClass(eventString, PaymentApprovedVo.class);
//            mypageService.createUserFromMessage(userCreatedVo);
            ContractDto contractDto = contractService.updateContractApproved(paymentApprovedVo);
            break;
        case "TalentItemContractFailed":
            log.info("## 계약 실패");
            TalentItemContractFailedVo vo = parseToClass(eventString, TalentItemContractFailedVo.class);
            Long talentItemId = vo.getContractDto().getTalentItemId();
            contractService.deleteByTalentItemId(talentItemId);
            break;
        default:
            break;
    }
}

    private <T> T parseToClass(String eventString, Class<T> clazz) {
        try {
            return mapper.readValue(eventString, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, String> parseToMap(String eventString) {
        Map<String, String> map = null;
        try {
            map = mapper.readValue(eventString, Map.class);
        } catch (JsonProcessingException e) {
            log.error(e.toString());
        }
        return map;
    }


}
