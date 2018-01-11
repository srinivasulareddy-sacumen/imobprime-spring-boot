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
@Table(name = "corretor")
public class Agent implements Serializable {

	private static final long serialVersionUID = 5190267060778924679L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_corretor")
	private Integer id;

	@Column(name = "nome_corretor", nullable = false, length = 255)
	private String name;

	@Column(name = "cpf", nullable = false, length = 15)
	private String cpf;

	@Column(name = "creci", nullable = false)
	private Integer creci;

	@Column(name = "email", nullable = false, length = 65)
	private String email;

	@Column(name = "site", nullable = true, length = 255)
	private String site;

	@Column(name = "telefone", nullable = true, length = 14)
	private String phoneNumber;

	@Column(name = "celular", nullable = true, length = 15)
	private String cellPhoneNumber;

	@ManyToOne
	@JoinColumn(name = "id_imobiliaria")
	private RealEstate realEstate;

	@ManyToOne
	@JoinColumn(name = "id_estado_atuacao")
	private State state;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private City city;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCreci() {
		return creci;
	}

	public void setCreci(Integer creci) {
		this.creci = creci;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
