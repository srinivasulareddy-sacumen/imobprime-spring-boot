package org.imobprime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class City implements Serializable {

	private static final long serialVersionUID = -9009079443320967061L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cidade")
	private Integer id;
	
	@Column(name = "nome_cidade", nullable = false, length = 255)
	private String name;
	
}
