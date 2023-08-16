package com.liderit.liderit.service;

import com.liderit.liderit.entity.DTO.ShowcaseDTO;
import com.liderit.liderit.entity.Showcase;
import com.liderit.liderit.repository.ShowcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShowcaseService {
    private final ShowcaseRepository showcaseRepository;

    @Autowired
    public ShowcaseService(ShowcaseRepository showcaseRepository) {
        this.showcaseRepository = showcaseRepository;
    }

    public ShowcaseDTO findById(Integer id) {
        return new ShowcaseDTO(Objects.requireNonNull(showcaseRepository.findById(id).stream().findAny().orElse(null)));
    }

    public List<ShowcaseDTO> getAllShowcase() {
        List<ShowcaseDTO> result = new ArrayList<>();
        showcaseRepository.findAll().forEach(showcase -> result.add(new ShowcaseDTO(showcase)));
        return result;
    }

    public List<ShowcaseDTO> findByType(String type) {
        return showcaseRepository.findByTypeIgnoreCase(type).stream().map(ShowcaseDTO::new).collect(Collectors.toList());
    }


    public List<ShowcaseDTO> findByAddress(String address) {
        return showcaseRepository.findByAddressIgnoreCase(address).stream().map(ShowcaseDTO::new).collect(Collectors.toList());
    }

    public List<ShowcaseDTO> findByCreatedAtBetween(LocalDate start, LocalDate end) {
        return showcaseRepository.findByCreatedAtBetween(start, end).stream().map(ShowcaseDTO::new).collect(Collectors.toList());
    }

    public List<ShowcaseDTO> findByLastUpdateDateBetween(LocalDate start, LocalDate end) {
        return showcaseRepository.findByLastUpdateDateBetween(start, end).stream().map(ShowcaseDTO::new).collect(Collectors.toList());
    }

    public void deleteShowcase(Integer id){
        showcaseRepository.deleteById(id);
    }

    public void saveShowcase(Showcase showcase){
        showcaseRepository.save(showcase);
    }



}
