package me.max.recipesite.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.max.recipesite.model.Recipe;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeService {
    private final FilesService filesService;

    @PostConstruct
    private void init(){
        readFromFile();
    }
    private Map<Integer, Recipe> recipes = new TreeMap<>();
    private int id = 0;

    public RecipeService(FilesService filesService) {
        this.filesService = filesService;
    }
    public void addRecipe(Recipe recipe){
        recipes.put(id,recipe);
        id++;
        saveToFile();
    }
    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }

    public Recipe getAllRecipes(){
        return (Recipe) recipes;
    }

    public void editRecipe(int id , Recipe recipe) throws Exception {
        if (recipes.containsKey(id)) {
            recipes.put(id,recipe);
        } else {
            throw new Exception("Отсутствует рецепт с таким идентификатором");
        }
        saveToFile();
    }

    public boolean delRecipe(int id){
        if (recipes.containsKey(id)){
            recipes.remove(id);
            return true;
        }
        return false;
    }

    private void saveToFile(){
        filesService.saveToFile(recipes,"recipe");
    }
    private void readFromFile(){
        String json = filesService.readFromFile("recipe.json");
        try {
            recipes = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipe>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
