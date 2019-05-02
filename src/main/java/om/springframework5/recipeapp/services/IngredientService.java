package om.springframework5.recipeapp.services;

import om.springframework5.recipeapp.commands.IngredientCommand;
import om.springframework5.recipeapp.domain.Ingredient;

import java.util.Set;

public interface IngredientService {

    Set<Ingredient> getIngredients();

    Ingredient findById(Long l);

    IngredientCommand saveRecipeCommand(IngredientCommand command);

    IngredientCommand findCommandById(Long id);

    //void deleteById(Long idToDelete);

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
