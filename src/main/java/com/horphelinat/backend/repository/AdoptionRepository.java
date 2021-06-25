package com.horphelinat.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Adoption;
import com.horphelinat.backend.model.Orphelin;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long>{
	@Query("SELECT a FROM Adoption a where isdelete=false ORDER BY a.date DESC ")
	List<Adoption>  ListAdoptionEnCours();
}
