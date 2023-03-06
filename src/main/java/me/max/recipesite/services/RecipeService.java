package me.max.recipesite.services;


import me.max.recipesite.dto.RecipeDTO;
import me.max.recipesite.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {
    private final Map<Integer, Recipe> recipes = new HashMap<>();
    private int idCounter = 0;
    public RecipeDTO addRecipe(Recipe recipe){
        int id = idCounter++;
        recipes.put(id,recipe);
        return RecipeDTO.from(id,recipe);
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return RecipeDTO.from(id,recipe);
        }
        return null;
    }
}
