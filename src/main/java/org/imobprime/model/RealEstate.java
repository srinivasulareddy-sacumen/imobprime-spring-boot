package org.imobprime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imobiliaria")
public class RealEstate implements Serializable {

	private static final long serialVersionUID = 7652175499822564556L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_imobiliaria")
	private Integer id;
	
	@Column(name = "razao_social", nullable = false, length = 255)
	private String name;
	
	@Column(name = "cnpj", nullable = false)
	private Integer cnpj;
	
	@Column(name = "cofeci", nullable = false)
	private Integer cofeci;
	
	@Column(name = "logo_path", nullable = true, length = 255)
	private String logoImagePath;
	
	@Column(name = "endereco_numero", nullable = true)
	private Integer adressNumber;
	
	@Column(name = "endereco_complemento", nullable = true, length = 55)
	private String adressDescription;
	
	@ManyToOne
    @JoinColumn(name = "id_endereco_cep")
	private ZipCode addressZipCode;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getCofeci() {
		return cofeci;
	}

	public void setCofeci(Integer cofeci) {
		this.cofeci = cofeci;
	}

	public String getLogoImagePath() {
		return logoImagePath;
	}

	public void setLogoImagePath(String logoImagePath) {
		this.logoImagePath = logoImagePath;
	}

	public Integer getAdressNumber() {
		return adressNumber;
	}

	public void setAdressNumber(Integer adressNumber) {
		this.adressNumber = adressNumber;
	}

	public String getAdressDescription() {
		return adressDescription;
	}

	public void setAdressDescription(String adressDescription) {
		this.adressDescription = adressDescription;
	}

	public ZipCode getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(ZipCode addressZipCode) {
		this.addressZipCode = addressZipCode;
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
		RealEstate other = (RealEstate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
