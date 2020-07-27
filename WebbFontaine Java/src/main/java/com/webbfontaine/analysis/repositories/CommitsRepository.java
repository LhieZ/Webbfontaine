package com.webbfontaine.analysis.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webbfontaine.analysis.domain.Commits; 

@Repository
public interface CommitsRepository extends CrudRepository<Commits, Long> {
	Iterable<Commits> findAll();
	List<Commits> findByProjectsId(Long projectIdentifier);
}
