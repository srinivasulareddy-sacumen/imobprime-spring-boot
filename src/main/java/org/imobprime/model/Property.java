package org.imobprime.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Property implements Serializable {

	private static final long serialVersionUID = -3289547475513964187L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_imovel")
	private Integer id;
	
	@Column(name = "imagem_path", nullable = true, length = 255)
	private String imagePath;
	
	@Column(name = "area_total", nullable = true)
	private Double totalArea;
	
	@Column(name = "numero_quartos", nullable = true)
	private Integer bedrooms;
	
	@Column(name = "numero_banheiros", nullable = true)
	private Integer bathrooms;
	
	@Column(name = "numero_garagens", nullable = true)
	private Integer garages;
	
	@Column(name = "descricao", nullable = true, columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "valor", nullable = true)
	private BigDecimal price;
	
	@Column(name = "valor_condominio", nullable = true)
	private BigDecimal priceCondo;
	
	@Column(name = "dados_endereco", nullable = true)
	private String addressData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Double getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public Integer getGarages() {
		return garages;
	}

	public void setGarages(Integer garages) {
		this.garages = garages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceCondo() {
		return priceCondo;
	}

	public void setPriceCondo(BigDecimal priceCondo) {
		this.priceCondo = priceCondo;
	}

	public String getAddressData() {
		return addressData;
	}

	public void setAddressData(String addressData) {
		this.addressData = addressData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
