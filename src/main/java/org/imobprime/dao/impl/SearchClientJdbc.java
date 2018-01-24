package org.imobprime.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.dao.SearchClientDAO;
import org.imobprime.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchClientJdbc implements SearchClientDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<Client> findAll(ClientSearchDTO clientSearchDTO) {
		String sqlQuery = 
			"select cliente.* from cliente " + 
			"left outer join corretor on ( cliente.id_corretor = corretor.id_corretor ) " + 
			"where 1 = 1 \n";
		
		final List<Object> params = new ArrayList<>();
		
		if(clientSearchDTO.getName() != null && !"".equals(clientSearchDTO.getName().trim())) {
			sqlQuery += "and cliente.nome_cliente like ? \n";
			params.add("%" + clientSearchDTO.getName() + "%");
		}
		
		if(clientSearchDTO.getCpf() != null && !"".equals(clientSearchDTO.getCpf().trim())) {
			sqlQuery += "and cliente.cpf like ? \n";
			params.add("%" + clientSearchDTO.getCpf() + "%");
		}
		
		if(clientSearchDTO.getStateId() != null) {
			sqlQuery += "and `atributos` -> '$.endereco.cidade.estado.id_estado' = ? \n";
			params.add(clientSearchDTO.getStateId());
		}
		
		if(clientSearchDTO.getCityId() != null) {
			sqlQuery += "and `atributos` -> '$.endereco.cidade.id_cidade' = ? \n";
			params.add(clientSearchDTO.getCityId());
		}
		
		sqlQuery += 
			"order by cliente.nome_cliente asc " + 
			"limit 0, 25";
		
		System.out.println("\n" + sqlQuery);
		System.out.println(params + "\n");
		
		return jdbcTemplate.query(
			sqlQuery, params.toArray(),
			(rs, rowNum) -> {
				Client client = new Client();
				
				client.setId(rs.getInt("id_cliente"));
				client.setName(rs.getString("nome_cliente"));
				client.setCpf(rs.getString("cpf"));
				client.setEmail(rs.getString("email"));
				client.setPhoneNumber(rs.getString("telefone"));
				client.setCellPhoneNumber(rs.getString("celular"));
				client.setAttributes(rs.getString("atributos"));
				
				return client;
			});
	}

}
