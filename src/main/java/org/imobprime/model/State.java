package org.imobprime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class State implements Serializable {

	private static final long serialVersionUID = 5716155649361167337L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_estado")
	private Integer id;
	
	@Column(name = "nome_estado", nullable = false, length = 255)
	private String name;
	
	@Column(name = "sigla_estado", nullable = false, length = 2)
	private String stateAbbreviation;
	
}
