package com.liderit.liderit.controller;

import com.liderit.liderit.entity.DTO.ShowcaseDTO;
import com.liderit.liderit.entity.Showcase;
import com.liderit.liderit.repository.ShowcaseRepository;
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
    private final ShowcaseRepository showcaseRepository;


    @Autowired
    public ShowcaseController(ShowcaseService showcaseService, ShowcaseRepository showcaseRepository) {
        this.showcaseService = showcaseService;
        this.showcaseRepository = showcaseRepository;
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

    //- Удаление витрины
    @DeleteMapping("/showcase/{id}")
    public void deleteShowcase(@PathVariable Integer id) {
        showcaseService.deleteShowcase(id);
    }

    //- Добавить витрину
    @PostMapping("/showcase")
    public void createShowcase(@RequestParam(name = "name") String name,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "type") String type,
                               @RequestParam(name = "createdAt") LocalDate createdAt,
                               @RequestParam(name = "lastUpdateDate") LocalDate lastUpdateDate) {
        showcaseService.saveShowcase(new Showcase(name, address, type, createdAt, lastUpdateDate));
    }

    //- Изменение данных витрины
    @PostMapping("/showcase/{id}")
    public void updateShowcase(@PathVariable Integer id,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "type") String type,
                               @RequestParam(name = "createdAt") LocalDate createdAt,
                               @RequestParam(name = "lastUpdateDate") LocalDate lastUpdateDate) {
        Showcase showcase = showcaseRepository.findById(id).orElse(null);
        showcase.setName(name);
        showcase.setAddress(address);
        showcase.setType(type);
        showcase.setCreatedAt(createdAt);
        showcase.setLastUpdateDate(lastUpdateDate);
        showcaseService.saveShowcase(showcase);
    }
}

