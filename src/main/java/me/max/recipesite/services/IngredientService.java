package me.max.recipesite.services;
import me.max.recipesite.model.Ingredient;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientService {
    private final Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private int id = 0;
    public void addIngredient(Ingredient ingredient){
        ingredients.put(id,ingredient);
        id++;
    }
    public Ingredient getIngredient(int id){
        return ingredients.get(id);
    }

    public boolean delIngredient(int id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return true;
        }
        return false;
    }

    public Ingredient editIngredient(int id , Ingredient ingredient){
        if (ingredient == null) {
            return null;
        }
        ingredients.put(id,ingredient);
        return ingredient;
    }

}