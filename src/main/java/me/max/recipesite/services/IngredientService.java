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

    public Ingredient getAllIngredients(){
        return (Ingredient) ingredients;
    }
    public boolean delIngredient(int id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return true;
        }
        return false;
    }

    public Ingredient editIngredient(int id , Ingredient ingredient) throws Exception {
        if (ingredients.containsKey(id)) {
            ingredients.put(id,ingredient);
        }
        throw new Exception("Отсутствует ингредиент с таким идентификатором");
    }
}