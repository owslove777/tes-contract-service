package com.contract.infrastructure.adapter.kafka;

import javax.persistence.*;

import com.contract.infrastructure.adapter.kafka.AbstractEvent;

@Entity
@Table(name = "contract_reserved")
public class ContractReserved extends AbstractEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    String talentCategory;
    public String getTalentCategory() {
        return talentCategory;
    }
    public void setName(String talentCategory) {
        this.talentCategory = talentCategory;
    }

    String requirement;
    public String getRequirement() {
        return requirement;
    }
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

}
