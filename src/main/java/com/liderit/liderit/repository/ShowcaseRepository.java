package com.liderit.liderit.repository;

import com.liderit.liderit.entity.Showcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ShowcaseRepository extends JpaRepository<Showcase, Integer> {
    List<Showcase> findByTypeIgnoreCase(String type);

    List<Showcase> findByAddressIgnoreCase(String address);

    List<Showcase> findByCreatedAtBetween(LocalDate start, LocalDate end);

    List<Showcase> findByLastUpdateDateBetween(LocalDate start, LocalDate end);


}
