package org.imobprime.repository;

import org.imobprime.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Integer> {

}
