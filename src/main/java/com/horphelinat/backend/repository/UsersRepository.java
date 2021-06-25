package com.horphelinat.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUsername(String username);
	Optional<Users> findById(Long id);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	@Query("SELECT o FROM Users o where isdelete=false and id != :id ORDER BY o.id DESC ")
	List<Users>  ListUsersNotDelete(@Param("id") Long id);
}
