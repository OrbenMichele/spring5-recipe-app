package om.springframework5.recipeapp.bootstrap;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import om.springframework5.recipeapp.domain.*;
import om.springframework5.recipeapp.repositories.CategoryRepository;
import om.springframework5.recipeapp.repositories.RecipeRepository;
import om.springframework5.recipeapp.repositories.UnitOfMesureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Data
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMesureRepository unitOfMesureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMesureRepository unitOfMesureRepository) {

        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMesureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        //get UOMs
        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMesureRepository.findByDescription("Tablespoon");

        if (!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMesureRepository.findByDescription("Teaspoon");

        if (!teaspoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMesureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMesureRepository.findByDescription("Pinch");

        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMesureRepository.findByDescription("Cup");

        if (!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found.");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        //get categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found.");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found.");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if (!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found.");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if (!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found.");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        //Guacamole Recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.getCategories().add(mexicanCategory);
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.setCookTime(0);
        guacRecipe.setDirection("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.;" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.);" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.;" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacRecipe.setDifficulty(Difficulty.EASY);
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");

        guacRecipe.setNotes(guacamoleNotes);

        guacRecipe.addingIngretient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addingIngretient(new Ingredient("Kosher salt", new BigDecimal(.5), teaspoonUom));
        guacRecipe.addingIngretient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoonUom));
        guacRecipe.addingIngretient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
        guacRecipe.addingIngretient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.addingIngretient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoonUom));
        guacRecipe.addingIngretient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), eachUom));

        //add to return list
        recipes.add(guacRecipe);

        return recipes;

    }
}
