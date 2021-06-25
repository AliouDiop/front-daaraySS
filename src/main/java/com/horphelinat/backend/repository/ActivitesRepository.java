package com.horphelinat.backend.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Activites;

@Repository
public interface ActivitesRepository extends JpaRepository<Activites, Long> {

	@Query("SELECT a FROM Activites a ORDER BY a.date DESC ")
	List<Activites>  findAllActivitesDESC();
	
	@Query("SELECT a FROM Activites a ORDER BY a.date DESC ")
	List<Activites>  HistoriqueActivtes();
	
}
