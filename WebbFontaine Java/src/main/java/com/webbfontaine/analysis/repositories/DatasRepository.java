package com.webbfontaine.analysis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webbfontaine.analysis.domain.Projects; 

@Repository
public interface DatasRepository extends CrudRepository<Projects, Long> {
	Iterable<Projects> findAll();
}
