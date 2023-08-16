package com.liderit.liderit.service;

import com.liderit.liderit.entity.DTO.ProductDTO;
import com.liderit.liderit.entity.Product;
import com.liderit.liderit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findByShowcaseId(Integer id) {
        return productRepository.findByShowcaseId(id).stream().map(ProductDTO::new).collect(Collectors.toList());
    }
    public List<ProductDTO> findByProductId(Integer showcaseId, Integer productId) {
        return productRepository.findByShowcaseIdAndId(showcaseId,productId).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<ProductDTO> findByType(Integer id, String type) {
        return productRepository.findByShowcaseIdAndType(id, type).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<ProductDTO> findAllByPriceGreater(Integer id, String price) {
        return productRepository.findAllByShowcaseIdAndPriceGreaterThanEqual(id, price).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<ProductDTO> findAllByPriceLess(Integer id, String price) {
        return productRepository.findAllByShowcaseIdAndPriceLessThanEqual(id, price).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<ProductDTO> findAllByPriceBetween(Integer id, String startPrice, String endPrice) {
        return productRepository.findAllByShowcaseIdAndPriceBetween(id, startPrice, endPrice).stream().map(ProductDTO::new).collect(Collectors.toList());
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
