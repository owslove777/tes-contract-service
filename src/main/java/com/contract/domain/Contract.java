package com.contract.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Contract {

	String talentCategory;
	Date startTime;
	Date endTime;
	Location location;
	int price;
	String Requirement;

	@Id @GeneratedValue
	Long id;

	public String getTalentCategory() {
		return talentCategory;
	}
	public void setTalentCategory(String talentCategory) {
		this.talentCategory = talentCategory;
	}

	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public Long getId() {
		return id;
	}

	// public void save(){
	// 	Repository repository = ContractApplication.getApplicationContext().getBean(Repository.class);
	// 	repository.save(this);
	// }

}
