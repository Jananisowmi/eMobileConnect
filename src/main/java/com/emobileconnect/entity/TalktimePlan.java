package com.emobileconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="talktime_plan")
public class TalktimePlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer talktimePlanId;
	private String  planDescription;
	private String  planType;
	private Integer validity;
	private String talktimeRange;
	private Double price;
	

}
