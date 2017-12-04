package org.imobprime.repository;

import java.util.List;

import org.imobprime.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByNameOrderByNameAsc(String name);
	
}
