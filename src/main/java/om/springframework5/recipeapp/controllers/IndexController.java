package om.springframework5.recipeapp.controllers;


import om.springframework5.recipeapp.domain.Category;
import om.springframework5.recipeapp.domain.UnitOfMeasure;
import om.springframework5.recipeapp.repositories.CategoryRepository;
import om.springframework5.recipeapp.repositories.UnitOfMesureRepository;
import om.springframework5.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
