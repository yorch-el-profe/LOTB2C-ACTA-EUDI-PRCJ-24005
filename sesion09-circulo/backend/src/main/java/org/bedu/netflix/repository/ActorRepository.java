package org.bedu.netflix.repository;

import java.util.Optional;

import org.bedu.netflix.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    
    Optional<Actor> findByName(String name);
}
