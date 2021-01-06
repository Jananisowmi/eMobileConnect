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
@Table(name="mobile_number")
public class MobileNumber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer mobileId;
	private Long mobileNumber;
	private String mobileStatus;
}
