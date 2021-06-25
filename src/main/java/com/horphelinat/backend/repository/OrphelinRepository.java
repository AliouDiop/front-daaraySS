package com.horphelinat.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Orphelin;

@Repository
public interface OrphelinRepository extends JpaRepository<Orphelin, Long>{
	@Query("SELECT o FROM Orphelin o where isactive=true ORDER BY o.dateentree DESC ")
	List<Orphelin>  ListOrphelinActive();
}
