package com.reference.order.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class OrderEntity {

	@Id
	private Integer orderId;
	private Integer corporateAccountId;
	private Integer lineOfBusinessId;
	private String businessUnit;
	private String serviceOffering;
	private String originArea;
	private String destinationArea;
	private Date pickupDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCorporateAccountId() {
		return corporateAccountId;
	}

	public void setCorporateAccountId(Integer corporateAccountId) {
		this.corporateAccountId = corporateAccountId;
	}

	public Integer getLineOfBusinessId() {
		return lineOfBusinessId;
	}

	public void setLineOfBusinessId(Integer lineOfBusinessId) {
		this.lineOfBusinessId = lineOfBusinessId;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getServiceOffering() {
		return serviceOffering;
	}

	public void setServiceOffering(String serviceOffering) {
		this.serviceOffering = serviceOffering;
	}

	public String getOriginArea() {
		return originArea;
	}

	public void setOriginArea(String originArea) {
		this.originArea = originArea;
	}

	public String getDestinationArea() {
		return destinationArea;
	}

	public void setDestinationArea(String destinationArea) {
		this.destinationArea = destinationArea;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

}
