package com.liderit.liderit.controller;

import com.liderit.liderit.entity.DTO.ShowcaseDTO;
import com.liderit.liderit.service.ShowcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/liderIt")
public class ShowcaseController {
    private final ShowcaseService showcaseService;


    @Autowired
    public ShowcaseController(ShowcaseService showcaseService) {
        this.showcaseService = showcaseService;
    }


    //Получить все витрины
    //должна быть возможность фильтрации витрыны по (
    //типу,
    //адресу,
    @GetMapping("/showcase")
    public List<ShowcaseDTO> getShowcases(@RequestParam(name = "type", required = false) String type,
                                          @RequestParam(name = "address", required = false) String address) {
        List<ShowcaseDTO> result = new ArrayList<>();
        if (type != null) {
            result.addAll(showcaseService.findByType(type));
        } else if (address != null) {
            result.addAll(showcaseService.findByAddress(address));
        } else {
            result.addAll(showcaseService.getAllShowcase());
        }
        return result;
    }

    @GetMapping("/showcase/{id}")
    public ShowcaseDTO getShowcases(@PathVariable Integer id) {
        return showcaseService.findById(id);
    }


    //    за период по дате создания,
    @GetMapping("/showcaseByCreatedAt")
    public List<ShowcaseDTO> findByCreatedAtBetween(@RequestParam(name = "startDate") LocalDate startDate,
                                                    @RequestParam(name = "endDate") LocalDate endDate
    ) {
        return showcaseService.findByCreatedAtBetween(startDate, endDate);
    }

    //    за период по дате последней актуализации)
    @GetMapping("/showcaseByLastUpdateDate")
    public List<ShowcaseDTO> findByLastUpdateDateBetween(@RequestParam(name = "startDate") LocalDate startDate,
                                                         @RequestParam(name = "endDate") LocalDate endDate
    ) {
        return showcaseService.findByLastUpdateDateBetween(startDate, endDate);
    }


//- Добавить витрину
//- Добавить товар на витрину
//- Изменение данных витрины
//- Изменение данных товара
//- Удаление витрины
//- Удаление товар
}

