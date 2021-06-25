package com.horphelinat.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Adoption;
import com.horphelinat.backend.model.Donateur;
import com.horphelinat.backend.model.Dons;
import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Tuteur;

@Repository
public interface DonsRepository extends JpaRepository<Dons, Long>{
	@Query("SELECT a FROM Dons a where isdelete=false ORDER BY a.id DESC ")
	List<Dons>  ListDonsEnCours();
}
