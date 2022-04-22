package com.contract.domain;

import com.contract.AbstractEvent;

public class ContractReserved extends AbstractEvent {
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
