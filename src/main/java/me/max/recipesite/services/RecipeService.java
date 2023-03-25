package me.max.recipesite.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.max.recipesite.model.Recipe;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeService {
    private final FilesService filesService;
    private final RecipeFilesService recipeFilesService;

    @PostConstruct
    private void init(){
        readFromFile();
    }
    private Map<Integer, Recipe> recipes = new TreeMap<>();
    private int id = 0;

    public RecipeService(FilesService filesService, RecipeFilesService recipeFilesService) {
        this.filesService = filesService;
        this.recipeFilesService = recipeFilesService;
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

    private void saveToFile()
    {
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

    public Path createTextDataFile() throws IOException {
        Path path = recipeFilesService.createTempFile("recipesDataFile");
        for (Recipe recipe : recipes.values()) {
            try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.append(recipe.getRecipeName()).append("\n \n").append("Cooking time: ").append(String.valueOf(recipe.getCookingTime())).append(" minutes.").append("\n");
                writer.append("\n");
                writer.append("Ingredients: \n \n");
                recipe.getIngredients().forEach(ingredient -> {
                    try {
                        writer.append(" - ").append(ingredient.getIngredName()).append(" - ").append(String.valueOf(ingredient.getAmount())).append(" ").append(ingredient.getMeasure()).append("\n \n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                writer.append("\n");
                writer.append("Cooking instructions: \n \n");
                recipe.getSteps().forEach(step -> {
                    try {
                        writer.append(" > ").append(step).append("\n \n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                writer.append("\n \n");
            }
        }
        return path;
    }





}
