package com.liderit.liderit.controller;

import com.liderit.liderit.dto.ShowcaseDto;
import com.liderit.liderit.entity.Showcase;
import com.liderit.liderit.service.ShowcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/liderIt/showcase")
public class ShowcaseController {
    private final ShowcaseService showcaseService;


    @Autowired
    public ShowcaseController(ShowcaseService showcaseService) {
        this.showcaseService = showcaseService;
    }

    @GetMapping()
    public List<ShowcaseDto> getShowcases(@RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "type", required = false) String type,
                                          @RequestParam(name = "address", required = false) String address,
                                          @RequestParam(name = "startCreatedAt", required = false) LocalDate createdAtStartDate,
                                          @RequestParam(name = "endCreatedAt", required = false) LocalDate createdAtEndDate,
                                          @RequestParam(name = "startLastUpdateDate", required = false) LocalDate lastUpdateDateStartDate,
                                          @RequestParam(name = "endLastUpdateDate", required = false) LocalDate lastUpdateDateEndDate) {
        return showcaseService.getAllShowcase()
                .stream()
                .filter(name != null ? showcaseDTO -> showcaseDTO.getType().equalsIgnoreCase(name) : showcaseDTO -> true)
                .filter(type != null ? showcaseDTO -> showcaseDTO.getType().equalsIgnoreCase(type) : showcaseDTO -> true)
                .filter(address != null ? showcaseDTO -> showcaseDTO.getAddress().equalsIgnoreCase(address) : showcaseDTO -> true)
                .filter(createdAtStartDate != null ? showcaseDTO -> showcaseDTO.getCreatedAt().isAfter(createdAtStartDate) : showcaseDTO -> true)
                .filter(createdAtEndDate != null ? showcaseDTO -> showcaseDTO.getCreatedAt().isBefore(createdAtEndDate) : showcaseDTO -> true)
                .filter(lastUpdateDateStartDate != null ? showcaseDTO -> showcaseDTO.getCreatedAt().isAfter(lastUpdateDateStartDate) : showcaseDTO -> true)
                .filter(lastUpdateDateEndDate != null ? showcaseDTO -> showcaseDTO.getCreatedAt().isBefore(lastUpdateDateEndDate) : showcaseDTO -> true)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShowcaseDto getShowcases(@PathVariable Integer id) {
        return showcaseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShowcase(@PathVariable Integer id) {
        showcaseService.deleteShowcase(id);
    }

    @PostMapping()
    public void createShowcase(@RequestBody ShowcaseDto showcaseDTO) {
        showcaseService.saveShowcase(new Showcase(new ArrayList<>(),
                showcaseDTO.getName(),
                showcaseDTO.getAddress(),
                showcaseDTO.getType(),
                LocalDate.now(),
                LocalDate.now()));
    }

    @PatchMapping("/{id}")
    public void updateShowcase(@PathVariable Integer id,
                               @RequestBody ShowcaseDto showcaseDTO) {
        showcaseService.updateShowcase(id, showcaseDTO);
    }
}

