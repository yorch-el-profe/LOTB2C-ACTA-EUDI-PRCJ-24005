package org.bedu.netflix.repository;

import java.util.Optional;

import org.bedu.netflix.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    
    Optional<Director> findByName(String name);
}
