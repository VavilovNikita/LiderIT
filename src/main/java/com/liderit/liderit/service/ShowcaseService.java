package com.liderit.liderit.service;

import com.liderit.liderit.dto.ShowcaseDto;
import com.liderit.liderit.entity.Showcase;
import com.liderit.liderit.repository.ShowcaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowcaseService {
    private final ShowcaseRepository showcaseRepository;

    @Autowired
    public ShowcaseService(ShowcaseRepository showcaseRepository) {
        this.showcaseRepository = showcaseRepository;
    }

    public ShowcaseDto findById(Integer id) {
        Optional<Showcase> showcase = showcaseRepository.findById(id);
        if (showcase.isPresent()) {
            return new ShowcaseDto(showcase.get());
        }
        throw new EntityNotFoundException("Витрины с id:" + id + " не существует");
    }

    public List<ShowcaseDto> getAllShowcase() {
        List<ShowcaseDto> result = new ArrayList<>();
        showcaseRepository.findAll().forEach(showcase -> result.add(new ShowcaseDto(showcase)));
        if (result.isEmpty())
            throw new EntityNotFoundException("Витрин не найдено");
        return result;
    }

    public void deleteShowcase(Integer id) {
        showcaseRepository.deleteById(id);
    }

    public void saveShowcase(Showcase showcase) {
        showcase.setCreatedAt(LocalDate.now());
        showcase.setLastUpdateDate(LocalDate.now());
        showcaseRepository.save(showcase);
    }

    public void updateShowcase(Integer id, ShowcaseDto showcaseDTO) {
        Optional<Showcase> optShowcase = showcaseRepository.findById(id);
        if (optShowcase.isEmpty())
            throw new EntityNotFoundException("Витрины с id:" + id + " не существует");
        Showcase showcase = optShowcase.get();
        showcase.setName(showcaseDTO.getName());
        showcase.setAddress(showcaseDTO.getAddress());
        showcase.setType(showcaseDTO.getType());
        showcase.setLastUpdateDate(LocalDate.now());
        showcaseRepository.save(showcase);
    }


}
