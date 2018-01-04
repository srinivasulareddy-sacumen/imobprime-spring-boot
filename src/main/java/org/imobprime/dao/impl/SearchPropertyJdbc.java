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
		
		params.add(homePropertySearchDTO.getCity());
		
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
		
		if (!homePropertySearchDTO.getRegion().trim().equals("")) {
			query += "and upper(JSON_EXTRACT(`dados_endereco`, '$.bairro')) like ? \n";
			String region = "\"" + homePropertySearchDTO.getRegion().toUpperCase() + "%";
			//System.out.println(region);
			params.add(region);
		}

//			"and imovel.valor between 200000 and 400000\r\n" + 
//			"and imovel.area_total between 50 and 80\r\n" + 
//			"and imovel.numero_quartos > 3\r\n" + 
//			"and imovel.numero_garagens = 1\r\n";
		
		query +=
			"order by imovel.id_imovel desc " + 
			"limit 0, 50";
		
		System.out.println("\n" + query);
		System.out.println(params + "\n");
		
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
