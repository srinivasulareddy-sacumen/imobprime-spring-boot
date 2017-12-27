package org.imobprime.dao.impl;

import java.util.List;
import java.util.Map;

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
			query, new Object[] { 4500 },
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
