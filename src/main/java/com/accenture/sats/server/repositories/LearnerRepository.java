package com.accenture.sats.server.repositories;

import com.accenture.sats.server.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LearnerRepository extends JpaRepository<Learner, Long> {

    @Query("select l from Learner l where l.eid = ?1")
    Optional<Learner> findByEid(String eid);
}
