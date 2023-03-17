package me.max.recipesite.services;

import me.max.recipesite.model.Recipe;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeService {
    private final Map<Integer, Recipe> recipes = new TreeMap<>();
    private int id = 0;
    public void addRecipe(Recipe recipe){
        recipes.put(id,recipe);
        id++;
    }
    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }

    public Recipe getAllRecipes(){
        return (Recipe) recipes;
    }

    public Recipe editRecipe(int id , Recipe recipe) throws Exception {
        if (recipes.containsKey(id)) {
            recipes.put(id,recipe);
        } else {
            throw new Exception("Отсутствует рецепт с таким идентификатором");
        }
        return recipe;
    }

    public boolean delRecipe(int id){
        if (recipes.containsKey(id)){
            recipes.remove(id);
            return true;
        }
        return false;
    }
}
