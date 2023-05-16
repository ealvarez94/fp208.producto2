package com.example.demo.repositories;

import com.example.demo.modelo.Authority;
import com.example.demo.modelo.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(AuthorityName name);
}
