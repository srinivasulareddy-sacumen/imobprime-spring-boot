package org.imobprime.controller;

import java.math.BigDecimal;

public class PropertySearchDTO {

	private Integer ownerId;

	private Integer propertyTypeId;
	private Integer propertyStateId;

	private Integer stateId;
	private Integer cityId;

	private BigDecimal priceMin;
	private BigDecimal priceMax;

	private Double areaMin;
	private Double areaMax;

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(Integer propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public Integer getPropertyStateId() {
		return propertyStateId;
	}

	public void setPropertyStateId(Integer propertyStateId) {
		this.propertyStateId = propertyStateId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public BigDecimal getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}

	public BigDecimal getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}

	public Double getAreaMin() {
		return areaMin;
	}

	public void setAreaMin(Double areaMin) {
		this.areaMin = areaMin;
	}

	public Double getAreaMax() {
		return areaMax;
	}

	public void setAreaMax(Double areaMax) {
		this.areaMax = areaMax;
	}

	@Override
	public String toString() {
		return "{ \n"
				+ "\t ownerId=" + ownerId + ", \n"
				+ "\t propertyTypeId=" + propertyTypeId + ", \n"
				+ "\t propertyStateId=" + propertyStateId + ", \n"
				+ "\t stateId=" + stateId + ", \n"
				+ "\t cityId=" + cityId + ", \n"
				+ "\t priceMin=" + priceMin + ", \n"
				+ "\t priceMax=" + priceMax + ", \n"
				+ "\t areaMin=" + areaMin + ", \n"
				+ "\t areaMax=" + areaMax + " \n"
			 + "}";
	}

}
