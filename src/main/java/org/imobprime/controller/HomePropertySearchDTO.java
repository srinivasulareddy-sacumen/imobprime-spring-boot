package org.imobprime.controller;

public class HomePropertySearchDTO {

	private Integer city;
	private Integer propertyType;
	private String region;
	private String propertyState;

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

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
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

	@Override
	public String toString() {
		return "{"
				+ "propertyType=" + propertyType + ", city=" + city + ", region=" + region
				+ ", propertyState=" + propertyState + ", priceMin=" + priceMin + ", priceMax=" + priceMax
				+ ", areaMin=" + areaMin + ", areaMax=" + areaMax + ", bedrooms=" + bedrooms + ", garages=" + garages
			 + "}";
	}

}
