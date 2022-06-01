package com.contract.infrastructure.entity;

import com.contract.domain.data.ContractDto;
import com.contract.domain.enums.CONTRACT_STATUS;
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
	Long id;

	Long talentId;
	Long talentItemId;
	Long talentUserId;
	String talentUserNm;
	Long userId;
	String userNm;

	@Enumerated(EnumType.STRING)
	CONTRACT_STATUS contractStatus; // BEFORE_CONTRACT, ACCEPT_REQUESTED, ACCEPTED, REJECTED, PERFORMED, CANCELED

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime requestDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime acceptedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime rejectedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime performedDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime canceledDateTime;

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
				.build();
	}
}
