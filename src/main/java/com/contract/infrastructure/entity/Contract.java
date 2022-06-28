package com.contract.infrastructure.entity;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;
import com.contract.infrastructure.adapter.kafka.ContractReservedKafka;
import com.contract.infrastructure.adapter.kafka.ContractUpdated;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "tes_contract")
@Table(name = "tes_contract")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long talentId;
	private Long talentItemId;
	private Long talentUserId;
	private String talentUserNm;
	private Long userId;
	private String userNm;
	private String title;
	private Long price;

	@Enumerated(EnumType.STRING)
	private CONTRACT_STATUS contractStatus; // ACCEPT_REQUESTED, ACCEPTED, PAID, REJECTED, PERFORMED, CANCELED

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime requestDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime acceptedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime rejectedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime performedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime canceledDateTime;

	public static Contract parseFrom(ContractDto src) {
		return builder()
				.id(src.getId())
				.talentId(src.getTalentId())
				.talentItemId(src.getTalentItemId())
				.talentUserId(src.getTalentUserId())
				.talentUserNm(src.getTalentUserNm())
				.userId(src.getUserId())
				.userNm(src.getUserNm())
				.contractStatus(src.getContractStatus())
				.rejectedDateTime(src.getRejectedDateTime())
				.requestDateTime(src.getRequestDateTime())
				.acceptedDateTime(src.getAcceptedDateTime())
				.performedDateTime(src.getPerformedDateTime())
				.canceledDateTime(src.getCanceledDateTime())
				.price(src.getPrice())
				.title(src.getTitle())
				.build();
	}

	public ContractDto toDto() {
		return ContractDto.builder()
				.id(id)
				.talentId(talentId)
				.talentItemId(talentItemId)
				.talentUserId(talentUserId)
				.talentUserNm(talentUserNm)
				.userId(userId)
				.userNm(userNm)
				.contractStatus(contractStatus)
				.rejectedDateTime(rejectedDateTime)
				.requestDateTime(requestDateTime)
				.acceptedDateTime(acceptedDateTime)
				.performedDateTime(performedDateTime)
				.canceledDateTime(canceledDateTime)
				.price(price)
				.title(title)
				.build();
	}

	@PostPersist
	public void onPostPersist(){
		ContractReservedKafka contractReserved = ContractReservedKafka.builder()
				.contractDto(toDto())
				.build();
		contractReserved.publishAfterCommit();
	}

	@PostUpdate
	public void onPostUpdate(){
		ContractUpdated contractReserved = ContractUpdated.builder()
				.contractDto(toDto())
				.build();
		contractReserved.publishAfterCommit();
	}
}
