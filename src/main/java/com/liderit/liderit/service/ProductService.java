package com.liderit.liderit.service;

import com.liderit.liderit.dto.ProductDto;
import com.liderit.liderit.entity.Product;
import com.liderit.liderit.repository.ProductRepository;
import com.liderit.liderit.repository.ShowcaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ShowcaseRepository showcaseRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ShowcaseRepository showcaseRepository) {
        this.productRepository = productRepository;
        this.showcaseRepository = showcaseRepository;
    }

    public List<ProductDto> findByShowcaseId(Long id) {
        List<ProductDto> productDtoList = productRepository.findByShowcaseId(id).stream().map(ProductDto::new).toList();
        if (productDtoList.isEmpty())
            throw new EntityNotFoundException("Витрина с id:" + id + " пуста");
        return productDtoList;
    }

    public ProductDto findByProductId(Long showcaseId, Long productId) {
        Optional<Product> optionalProduct = productRepository.findByShowcaseIdAndId(showcaseId, productId);
        if (optionalProduct.isPresent())
            return new ProductDto(optionalProduct.get());
        throw new EntityNotFoundException("Товара с id:" + productId + " не существует");
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public void createProduct(Integer id, ProductDto productDTO) {
        showcaseRepository.findById(id)
                .ifPresent(showcase -> productRepository
                        .save(new Product(showcase
                                , productDTO.getPositionOnShowcase(),
                                productDTO.getName(),
                                productDTO.getType(),
                                productDTO.getPrice(),
                                LocalDate.now(),
                                LocalDate.now())));
    }

    public void updateProduct(Long showcaseId, Long productId, ProductDto productDTO) {
        Optional<Product> optionalProduct = productRepository.findByShowcaseIdAndId(showcaseId, productId);
        if (optionalProduct.isEmpty())
            throw new EntityNotFoundException("Товара с id:" + productId + " не существует");
        Product product = optionalProduct.get();
        product.setPosition_on_showcase(productDTO.getPositionOnShowcase());
        product.setName(productDTO.getName());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        product.setLastUpdateDate(LocalDate.now());
        productRepository.save(product);
    }
}
