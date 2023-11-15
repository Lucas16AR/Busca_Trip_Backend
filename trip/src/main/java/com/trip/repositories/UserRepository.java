package com.trip.repositories;
import com.trip.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username); 

    // haceme un metodo para traer un usuario by username, solo username sin password, con sql
    // @Query("select u from users u where u.username = ?1")
    // UserModel getUserByUsername(String username);


}