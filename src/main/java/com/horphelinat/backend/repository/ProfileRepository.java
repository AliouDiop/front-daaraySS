package com.horphelinat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
}
