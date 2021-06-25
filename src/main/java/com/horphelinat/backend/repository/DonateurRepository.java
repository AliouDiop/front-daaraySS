package com.horphelinat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Donateur;
import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Tuteur;

@Repository
public interface DonateurRepository extends JpaRepository<Donateur, Long>{
}
