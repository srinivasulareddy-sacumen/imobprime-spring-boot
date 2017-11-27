package org.imobprime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cep")
public class ZipCode implements Serializable {

	private static final long serialVersionUID = 5885136345196031617L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cep")
	private Integer id;
	
	@Column(name = "cep", nullable = false, length = 55)
	private String postalCode;
	
	@Column(name = "rua", nullable = false, length = 255)
	private String street;
	
	@Column(name = "bairro", nullable = false, length = 255)
	private String region;
	
	@Column(name = "tipo", nullable = false, length = 255)
	private String type;
	
	
}
