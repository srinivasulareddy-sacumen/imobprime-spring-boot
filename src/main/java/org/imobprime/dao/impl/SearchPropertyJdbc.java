package org.imobprime.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.imobprime.controller.HomePropertySearchDTO;
import org.imobprime.dao.SearchPropertyDAO;
import org.imobprime.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchPropertyJdbc implements SearchPropertyDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Property> findAllMostRecent(Map<String, String> parameters) {
		String query = 
			"select * from imovel " +
			"left outer join tipo_imovel on ( imovel.id_tipo_imovel = tipo_imovel.id_tipo_imovel ) " +
			"left outer join situacao_imovel on ( imovel.id_situacao_atual = situacao_imovel.id_situacao_imovel ) " +
			"where `dados_endereco` -> '$.cidade.id_cidade' = ? " +
			"and id_situacao_atual not in (2, 4) " +
			"order by id_imovel desc " +
			"limit 0, 50";
		
		return jdbcTemplate.query(
			query, new Object[] { Integer.parseInt(parameters.get("cityId")) },
			(rs, rowNum) -> {
				Property p = new Property();
				p.setId(rs.getInt("id_imovel"));
				p.setTotalArea(rs.getDouble("area_total"));
				p.setBedrooms(rs.getInt("numero_quartos"));
				p.setBathrooms(rs.getInt("numero_banheiros"));
				p.setGarages(rs.getInt("numero_garagens"));
				p.setDescription(rs.getString("descricao"));
				p.setPrice(rs.getBigDecimal("valor"));
				p.setPriceCondo(rs.getBigDecimal("valor_condominio"));
				p.setAddressData(rs.getString("dados_endereco"));
				return p;
			});
	}

	@Override
	public List<Property> findAll(HomePropertySearchDTO homePropertySearchDTO) {
		final List<Object> params = new ArrayList<>();
		
		String query = 
			"select * from imovel " + 
			"left outer join tipo_imovel on ( imovel.id_tipo_imovel = tipo_imovel.id_tipo_imovel ) " + 
			"left outer join situacao_imovel on ( imovel.id_situacao_atual = situacao_imovel.id_situacao_imovel ) \n" + 
			"where `dados_endereco` -> '$.cidade.id_cidade' = ? \n"; 
		
		// cityId is a required parameter
		params.add(homePropertySearchDTO.getCity());
		
		// the parameters above this comment are optional
		if (homePropertySearchDTO.getPropertyState() != null) {
			query += "and imovel.id_situacao_atual = ? \n";
			
			if (homePropertySearchDTO.getPropertyState().equals("for_sale")) {
				params.add(1);
			} else if (homePropertySearchDTO.getPropertyState().equals("for_rent")) {
				params.add(3);
			}
		}
		
		if (homePropertySearchDTO.getPropertyType() != null) {
			query += "and imovel.id_tipo_imovel = ? \n";
			params.add(homePropertySearchDTO.getPropertyType());
		}
		
		if (homePropertySearchDTO.getRegion() != null && !homePropertySearchDTO.getRegion().trim().equals("")) {
			query += "and upper(JSON_EXTRACT(`dados_endereco`, '$.bairro')) like ? \n";
			String region = "\"" + homePropertySearchDTO.getRegion().toUpperCase() + "%";
			//System.out.println(region);
			params.add(region);
		}

		if(homePropertySearchDTO.getPriceMin() != null && homePropertySearchDTO.getPriceMax() != null) {
			query += "and imovel.valor between ? and ? \n";
			params.add(homePropertySearchDTO.getPriceMin());
			params.add(homePropertySearchDTO.getPriceMax());
			
		} else if(homePropertySearchDTO.getPriceMin() != null) {
			query += "and imovel.valor >= ? \n";
			params.add(homePropertySearchDTO.getPriceMin());
			
		} else if(homePropertySearchDTO.getPriceMax() != null) {
			query += "and imovel.valor <= ? \n";
			params.add(homePropertySearchDTO.getPriceMax());
		}
		
		if(homePropertySearchDTO.getAreaMin() != null && homePropertySearchDTO.getAreaMax() != null) {
			query += "and imovel.area_total between ? and ? \n";
			params.add(homePropertySearchDTO.getAreaMin());
			params.add(homePropertySearchDTO.getAreaMax());
			
		} else if(homePropertySearchDTO.getAreaMin() != null) {
			query += "and imovel.area_total >= ? \n";
			params.add(homePropertySearchDTO.getAreaMin());
			
		} else if(homePropertySearchDTO.getAreaMax() != null) {
			query += "and imovel.area_total <= ? \n";
			params.add(homePropertySearchDTO.getAreaMax());
		}
		
		if(homePropertySearchDTO.getBedrooms() != null && !homePropertySearchDTO.getBedrooms().trim().equals("")) {
			if(homePropertySearchDTO.getBedrooms().equals("+3")) {
				query += "and imovel.numero_quartos > 3 \n";
			} else {
				query += "and imovel.numero_quartos = ? \n";
				params.add(Integer.parseInt(homePropertySearchDTO.getBedrooms()));
			}
		}
		
		if(homePropertySearchDTO.getGarages() != null && !homePropertySearchDTO.getGarages().trim().equals("")) {
			if(homePropertySearchDTO.getGarages().equals("+3")) {
				query += "and imovel.numero_garagens > 3 \n";
			} else {
				query += "and imovel.numero_garagens = ? \n";
				params.add(Integer.parseInt(homePropertySearchDTO.getGarages()));
			}
		}
		
		query +=
			"order by imovel.id_imovel desc " + 
			"limit 0, 50";
		
//		System.out.println("\n" + query);
//		System.out.println(params + "\n");
		
		return jdbcTemplate.query(
			query, params.toArray(),
			(rs, rowNum) -> {
				Property p = new Property();
				p.setId(rs.getInt("id_imovel"));
				p.setTotalArea(rs.getDouble("area_total"));
				p.setBedrooms(rs.getInt("numero_quartos"));
				p.setBathrooms(rs.getInt("numero_banheiros"));
				p.setGarages(rs.getInt("numero_garagens"));
				p.setDescription(rs.getString("descricao"));
				p.setPrice(rs.getBigDecimal("valor"));
				p.setPriceCondo(rs.getBigDecimal("valor_condominio"));
				p.setAddressData(rs.getString("dados_endereco"));
				return p;
			});
	}

}
