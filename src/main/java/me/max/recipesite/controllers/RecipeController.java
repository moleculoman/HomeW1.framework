package me.max.recipesite.controllers;
import me.max.recipesite.dto.RecipeDTO;
import me.max.recipesite.model.Recipe;
import org.springframework.web.bind.annotation.*;
import me.max.recipesite.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable ("id") int id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public RecipeDTO addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}