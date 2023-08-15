package com.liberit.liberit.controller;

import com.liberit.liberit.entity.ProductDTO;
import com.liberit.liberit.entity.ShowcaseDTO;
import com.liberit.liberit.service.ProductService;
import com.liberit.liberit.service.ShowcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    ShowcaseService showcaseService;

    ProductService productService;

    @Autowired
    public Controller(ShowcaseService showcaseService, ProductService productService) {
        this.showcaseService = showcaseService;
        this.productService = productService;
    }


    //Получить все витрины
    @GetMapping("/getAllShowcase")
    public List<ShowcaseDTO> getAllShowcase() {
        return showcaseService.getAllShowcase();
    }

    //- Получить все товары витрины
    @GetMapping("/getAllProductsByShowcase/{id}")
    public List<ProductDTO> getAllProductsByShowcase(@PathVariable("id") int id) {
        return showcaseService.getProductById(id);
    }

//    -- должна быть возможность фильтрации по типу
//-- должна быть возможность получить витрины по адресу
//-- должна быть возможность получить витрины за период по дате создания
//-- должна быть возможность получить витрины за период по дате последней актуализации

//-- должна быть возможность фильтрации по типу товара
//-- должна быть возможность фильтрации по диапозону цен
//- Добавить витрину
//- Добавить товар на витрину
//- Изменение данных витрины
//- Изменение данных товара
//- Удаление витрины
//- Удаление товар
}

