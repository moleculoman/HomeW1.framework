package me.max.recipesite.services;
import me.max.recipesite.model.Ingredient;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private final Map<Long, Ingredient> ingredientMap = new HashMap<>();
    private Long id = 0L;
    public void addIngredient(Ingredient ingredient){
        ingredientMap.put(id,ingredient);
        id++;
    }
    public Ingredient getIngredient(Long id){
        return ingredientMap.get(id);
    }
}