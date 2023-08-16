package com.liderit.liderit.controller;

import com.liderit.liderit.entity.DTO.ProductDTO;
import com.liderit.liderit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liderIt/showcase")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
}


//- Добавить витрину
//- Добавить товар на витрину
//- Изменение данных витрины
//- Изменение данных товара
//- Удаление витрины
//- Удаление товар


