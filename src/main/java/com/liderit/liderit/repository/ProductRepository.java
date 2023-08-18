package com.liderit.liderit.repository;

import com.liderit.liderit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByShowcaseId(Long showcaseId);
    Optional<Product> findByShowcaseIdAndId(Long showcase_id, Long id);


}
