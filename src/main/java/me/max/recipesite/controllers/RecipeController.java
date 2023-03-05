package me.max.recipesite.controllers;
import dto.RecipeDTO;
import model.Recipe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/{id}")
    public RecipeDTO getRecipe(int id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public RecipeDTO addRecipe(Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }}