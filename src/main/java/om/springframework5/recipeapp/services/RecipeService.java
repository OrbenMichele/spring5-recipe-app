package om.springframework5.recipeapp.services;

import om.springframework5.recipeapp.commands.RecipeCommand;
import om.springframework5.recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
