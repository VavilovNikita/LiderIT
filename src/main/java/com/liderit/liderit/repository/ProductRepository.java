package com.liderit.liderit.repository;

import com.liderit.liderit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByShowcaseId(Integer showcaseId);

    List<Product> findByShowcaseIdAndType(Integer id, String type);

    List<Product> findAllByShowcaseIdAndPriceGreaterThanEqual(Integer id, String price);

    List<Product> findAllByShowcaseIdAndPriceLessThanEqual(Integer id, String price);

    List<Product> findAllByShowcaseIdAndPriceBetween(Integer id, String startPrice, String endPrice);

}
