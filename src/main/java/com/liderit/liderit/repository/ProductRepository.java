package com.liderit.liderit.repository;

import com.liderit.liderit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByShowcaseId(Integer showcaseId);
    List<Product> findByShowcaseIdAndId(Integer showcaseId, Integer productId);

    List<Product> findByShowcaseIdAndType(Integer showcaseId, String type);

    List<Product> findAllByShowcaseIdAndPriceGreaterThanEqual(Integer showcaseId, String price);

    List<Product> findAllByShowcaseIdAndPriceLessThanEqual(Integer showcaseId, String price);

    List<Product> findAllByShowcaseIdAndPriceBetween(Integer showcaseId, String startPrice, String endPrice);

}
