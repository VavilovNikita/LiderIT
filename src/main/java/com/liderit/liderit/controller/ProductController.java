package com.liderit.liderit.controller;

import com.liderit.liderit.dto.ProductDto;
import com.liderit.liderit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/liderIt/showcase")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}/product")
    public List<ProductDto> getAllProductsByShowcase(@PathVariable("id") int id,
                                                     @RequestParam(name = "position_on_showcase", required = false) String position_on_showcase,
                                                     @RequestParam(name = "name", required = false) String name,
                                                     @RequestParam(name = "type", required = false) String type,
                                                     @RequestParam(name = "startPrice", required = false) Double startPrice,
                                                     @RequestParam(name = "endPrice", required = false) Double endPrice,
                                                     @RequestParam(name = "startCreatedAt", required = false) LocalDate startCreatedAt,
                                                     @RequestParam(name = "endCreatedAt", required = false) LocalDate endCreatedAt,
                                                     @RequestParam(name = "startLastUpdateDate", required = false) LocalDate startLastUpdateDate,
                                                     @RequestParam(name = "endLastUpdateDate", required = false) LocalDate endLastUpdateDate) {
        return productService.findByShowcaseId(id)
                .stream()
                .filter(position_on_showcase != null ? productDTO -> productDTO.getPositionOnShowcase().equalsIgnoreCase(position_on_showcase) : showcaseDTO -> true)
                .filter(name != null ? productDTO -> productDTO.getName().equalsIgnoreCase(name) : showcaseDTO -> true)
                .filter(type != null ? productDTO -> productDTO.getName().equalsIgnoreCase(type) : showcaseDTO -> true)
                .filter(startPrice != null ? productDTO -> productDTO.getPrice() >= startPrice : showcaseDTO -> true)
                .filter(endPrice != null ? productDTO -> productDTO.getPrice() <= endPrice : showcaseDTO -> true)
                .filter(startCreatedAt != null ? productDTO -> productDTO.getCreatedAt().isAfter(startCreatedAt) : showcaseDTO -> true)
                .filter(endCreatedAt != null ? productDTO -> productDTO.getCreatedAt().isBefore(endCreatedAt) : showcaseDTO -> true)
                .filter(startLastUpdateDate != null ? productDTO -> productDTO.getCreatedAt().isAfter(startLastUpdateDate) : showcaseDTO -> true)
                .filter(endLastUpdateDate != null ? productDTO -> productDTO.getCreatedAt().isBefore(endLastUpdateDate) : showcaseDTO -> true)
                .collect(Collectors.toList());
    }

    @GetMapping("/{showcaseId}/product/{productId}")
    public ProductDto getProductById(@PathVariable("showcaseId") Long showcaseId,
                                     @PathVariable("productId") Long productId) {
        return productService.findByProductId(showcaseId, productId);
    }

    @DeleteMapping("/{showcaseId}/product/{productId}")
    public void deleteShowcase(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping("/{id}/product")
    public void saveShowcase(@PathVariable Integer id, @RequestBody ProductDto productDTO) {
        productService.createProduct(id, productDTO);
    }

    @PatchMapping("/{showcaseId}/product/{productId}")
    public void updateShowcase(@PathVariable Long showcaseId,
                               @PathVariable Long productId,
                               @RequestBody ProductDto productDTO) {
        productService.updateProduct(showcaseId, productId, productDTO);
    }
}







