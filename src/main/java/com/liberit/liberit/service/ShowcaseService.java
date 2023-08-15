package com.liberit.liberit.service;

import com.liberit.liberit.entity.ProductDTO;
import com.liberit.liberit.entity.ShowcaseDTO;
import com.liberit.liberit.repository.ShowcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowcaseService {
    ShowcaseRepository showcaseRepository;

    @Autowired
    public ShowcaseService(ShowcaseRepository showcaseRepository) {
        this.showcaseRepository = showcaseRepository;
    }

    public List<ShowcaseDTO> getAllShowcase() {
        List<ShowcaseDTO> result = new ArrayList<>();
        showcaseRepository.findAll().forEach(showcase -> result.add(new ShowcaseDTO(showcase)));
        return result;
    }

    public List<ProductDTO> getProductById(int id) {
        List<ProductDTO> result = new ArrayList<>();
        if (showcaseRepository.findById(id).isPresent())
            showcaseRepository.findById(id).get().getProduct().forEach(product -> result.add(new ProductDTO(product)));
        return result;
    }


}
