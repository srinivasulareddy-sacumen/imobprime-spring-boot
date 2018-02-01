package org.imobprime.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.imobprime.controller.PropertySearchDTO;
import org.imobprime.dao.PropertyDAO;
import org.imobprime.model.Property;
import org.imobprime.model.PropertyState;
import org.imobprime.model.PropertyType;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyJPA implements PropertyDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Property> findAll() {
		TypedQuery<Property> query = entityManager.createQuery(
			"select p from Property p "
		  + "left join fetch p.type "
		  + "left join fetch p.state "
		  + "order by p.id DESC", Property.class);
		
		query.setMaxResults(25);
		
		return query.getResultList();
	}

	@Override
	public List<Property> findAll(PropertySearchDTO propertySearchDTO) {
		String query = 
			"select imovel.*, tipo_imovel.nome_tipo_imovel, situacao_imovel.nome_situacao_imovel \n" + 
			" from imovel \n" + 
			" left outer join tipo_imovel on ( imovel.id_tipo_imovel = tipo_imovel.id_tipo_imovel ) \n" + 
			" left outer join situacao_imovel on ( imovel.id_situacao_atual = situacao_imovel.id_situacao_imovel ) \n" + 
			"where 1 = 1 \n"; 
		
		if(propertySearchDTO.getPropertyTypeId() != null) {
			query += " and tipo_imovel.id_tipo_imovel = :propertyTypeId \n";
		}
		
		if(propertySearchDTO.getPropertyStateId() != null) {
			query += " and imovel.id_situacao_atual = :propertyStateId \n";
		}
		
		if(propertySearchDTO.getStateId() != null) {
			query += " and `dados_endereco` -> '$.cidade.estado.id_estado' = :stateId \n";
		}
		
		if(propertySearchDTO.getCityId() != null) {
			query += " and `dados_endereco` -> '$.cidade.id_cidade' = :cityId \n";
		}
		
		if(propertySearchDTO.getPriceMin() != null && propertySearchDTO.getPriceMax() != null) {
			query += " and imovel.valor between :priceMin and :priceMax \n";
			
		} else if(propertySearchDTO.getPriceMin() != null) {
			query += " and imovel.valor >= :priceMin \n";
			
		} else if(propertySearchDTO.getPriceMax() != null) {
			query += " and imovel.valor <= :priceMax \n";
		}
		
		if(propertySearchDTO.getAreaMin() != null && propertySearchDTO.getAreaMax() != null) {
			query += " and imovel.area_total between :areaMin and :areaMax \n";
			
		} else if(propertySearchDTO.getAreaMin() != null) {
			query += " and imovel.area_total >= :areaMin \n";
			
		} else if(propertySearchDTO.getAreaMax() != null) {
			query += " and imovel.area_total <= :areaMax \n";
		}
		
		query += 
			"order by imovel.id_imovel desc \n" + 
			"limit 0, 25";
		
		Query q = entityManager.createNativeQuery(query);
		
		if(propertySearchDTO.getPropertyTypeId() != null) {
			q.setParameter("propertyTypeId", propertySearchDTO.getPropertyTypeId());
		}
		
		if(propertySearchDTO.getPropertyStateId() != null) {
			q.setParameter("propertyStateId", propertySearchDTO.getPropertyStateId());
		}
		
		if(propertySearchDTO.getStateId() != null) {
			q.setParameter("stateId", propertySearchDTO.getStateId());
		}
		
		if(propertySearchDTO.getCityId() != null) {
			q.setParameter("cityId", propertySearchDTO.getCityId());
		}
		
		if(propertySearchDTO.getPriceMin() != null && propertySearchDTO.getPriceMax() != null) {
			q.setParameter("priceMin", propertySearchDTO.getPriceMin());
			q.setParameter("priceMax", propertySearchDTO.getPriceMax());
			
		} else if(propertySearchDTO.getPriceMin() != null) {
			q.setParameter("priceMin", propertySearchDTO.getPriceMin());
			
		} else if(propertySearchDTO.getPriceMax() != null) {
			q.setParameter("priceMax", propertySearchDTO.getPriceMax());
		}
		
		if(propertySearchDTO.getAreaMin() != null && propertySearchDTO.getAreaMax() != null) {
			q.setParameter("areaMin", propertySearchDTO.getAreaMin());
			q.setParameter("areaMax", propertySearchDTO.getAreaMax());
			
		} else if(propertySearchDTO.getAreaMin() != null) {
			q.setParameter("areaMin", propertySearchDTO.getAreaMin());
			
		} else if(propertySearchDTO.getAreaMax() != null) {
			q.setParameter("areaMax", propertySearchDTO.getAreaMax());
		}
		
		System.out.println("\n" + query + "\n");
		
		List<Object[]> resultList = q.getResultList();
		
		List<Property> properties = new ArrayList<>();
		
		for (Object[] result : resultList) {
			Property p = new Property();
			p.setId((Integer) result[0]);
			p.setImagePath((String) result[1]);
			p.setTotalArea((Double) result[2]);
			p.setBedrooms((Integer) result[3]);
			p.setBathrooms((Integer) result[4]);
			p.setGarages((Integer) result[5]);
			p.setDescription((String) result[6]);
			p.setPrice((BigDecimal) result[7]);
			p.setPriceCondo((BigDecimal) result[8]);
			
			// TODO: the type coming from query is Character and not String...
			p.setAddressData("{}");
			
			PropertyType type = new PropertyType();
			type.setName((String) result[12]);
			p.setType(type);
			
			PropertyState state = new PropertyState();
			state.setName((String) result[13]);
			p.setState(state);
			
			properties.add(p);
		}
		
		return properties;
	}

	@Override
	public Property findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
