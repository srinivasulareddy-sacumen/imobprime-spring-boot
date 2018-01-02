package org.imobprime.controller;

public class HomePropertySearchDTO {

	private Integer propertyType;
	private Integer city;
	private String region;
	private Integer propertyState;

	private Double priceMin;
	private Double priceMax;

	private Double areaMin;
	private Double areaMax;

	private String bedrooms;
	private String garages;

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(Integer propertyState) {
		this.propertyState = propertyState;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
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

	public String getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(String bedrooms) {
		this.bedrooms = bedrooms;
	}

	public String getGarages() {
		return garages;
	}

	public void setGarages(String garages) {
		this.garages = garages;
	}

}
