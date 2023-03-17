package me.max.recipesite.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.max.recipesite.model.Ingredient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientService {

    private final FilesService filesService;
    private Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private int id = 0;

    @PostConstruct
    private void init(){
        readFromFile();
    }

    public IngredientService(FilesService filesService) {
        this.filesService = filesService;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.put(id,ingredient);
        id++;
        saveToFile();
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
        } else {
            throw new Exception("Отсутствует ингредиент с таким идентификатором");
        }
        saveToFile();
        return ingredient;
    }

    private void saveToFile(){
        filesService.saveToFile(ingredients,"ingredients");
    }
    private void readFromFile(){
        String json = filesService.readFromFile("ingredient.json");
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredient>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}