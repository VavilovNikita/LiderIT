package com.liderit.liderit.repository;

import com.liderit.liderit.entity.Showcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowcaseRepository extends JpaRepository<Showcase, Integer> {
}
