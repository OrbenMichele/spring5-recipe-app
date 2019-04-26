package om.springframework5.recipeapp.controllers;


import om.springframework5.recipeapp.domain.Category;
import om.springframework5.recipeapp.domain.UnitOfMeasure;
import om.springframework5.recipeapp.repositories.CategoryRepository;
import om.springframework5.recipeapp.repositories.UnitOfMesureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMesureRepository unitOfMesureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMesureRepository.findByDescription("Teaspoon");

        System.out.println("Category ID is: " + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
