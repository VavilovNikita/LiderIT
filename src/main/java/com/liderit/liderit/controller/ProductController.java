package com.liderit.liderit.controller;

import com.liderit.liderit.entity.DTO.ProductDTO;
import com.liderit.liderit.entity.Product;
import com.liderit.liderit.repository.ProductRepository;
import com.liderit.liderit.repository.ShowcaseRepository;
import com.liderit.liderit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/liderIt/showcase")
public class ProductController {

    private final ProductService productService;
    private final ShowcaseRepository showcaseRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ShowcaseRepository showcaseRepository, ProductRepository productRepository) {
        this.productService = productService;
        this.showcaseRepository = showcaseRepository;
        this.productRepository = productRepository;
    }


    //- Получить все товары витрины
    //-- должна быть возможность фильтрации по типу товара
    @GetMapping("/{id}/product")
    public List<ProductDTO> getAllProductsByShowcase(@PathVariable("id") int id,
                                                     @RequestParam(name = "type", required = false) String type) {
        return type != null ?
                productService.findByType(id, type)
                :
                productService.findByShowcaseId(id);
    }

    @GetMapping("/{showcaseId}/product/{productId}")
    public List<ProductDTO> getProductById(@PathVariable("showcaseId") Integer showcaseId, @PathVariable("productId") Integer productId) {
        return productService.findByProductId(showcaseId, productId);
    }

    //-- должна быть возможность фильтрации по диапозону цен
    @GetMapping("/{id}/product/price")
    public List<ProductDTO> getByPrice(@PathVariable("id") int id,
                                       @RequestParam(name = "startPrice", required = false) String startPrice,
                                       @RequestParam(name = "endPrice", required = false) String endPrice) {
        if (startPrice != null && endPrice != null) {
            return productService.findAllByPriceBetween(id, startPrice, endPrice);
        }
        return startPrice != null ?
                productService.findAllByPriceGreater(id, startPrice) :
                productService.findAllByPriceLess(id, endPrice);
    }

    //- Удаление товар
    @DeleteMapping("/{showcaseId}/product/{productId}")
    public void deleteShowcase(@PathVariable Integer productId, @PathVariable String showcaseId) {
        productService.deleteProduct(productId);
    }

    //- Добавить товар на витрину
    @PostMapping("/{id}/product")
    public void saveShowcase(@PathVariable Integer id,
                             @RequestParam(name = "positionOnShowcase") String positionOnShowcase,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "type") String address,
                             @RequestParam(name = "price") String type,
                             @RequestParam(name = "createdAt") LocalDate createdAt,
                             @RequestParam(name = "lastUpdateDate") LocalDate lastUpdateDate) {
        productService.saveProduct(new Product(showcaseRepository.findById(id).orElse(null), positionOnShowcase, name, address, type, createdAt, lastUpdateDate));
    }
    //- Изменение данных товара
    @PostMapping("/{showcaseId}/product/{productId}")
    public void updateShowcase(@PathVariable Integer showcaseId,
                               @PathVariable Integer productId,
                             @RequestParam(name = "positionOnShowcase") String positionOnShowcase,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "type") String address,
                             @RequestParam(name = "price") String type,
                             @RequestParam(name = "createdAt") LocalDate createdAt,
                             @RequestParam(name = "lastUpdateDate") LocalDate lastUpdateDate) {
        Product product = productRepository.findByShowcaseIdAndId(showcaseId, productId).stream().findAny().orElse(null);
        product.setPosition_on_showcase(positionOnShowcase);
        product.setName(name);
        product.setType(address);
        product.setPrice(type);
        product.setCreatedAt(createdAt);
        product.setLastUpdateDate(lastUpdateDate);
        productService.saveProduct(product);
    }
}







