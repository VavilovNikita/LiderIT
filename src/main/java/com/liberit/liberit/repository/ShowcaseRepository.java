package com.liberit.liberit.repository;

import com.liberit.liberit.entity.Showcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowcaseRepository extends JpaRepository<Showcase,Integer> {
}
