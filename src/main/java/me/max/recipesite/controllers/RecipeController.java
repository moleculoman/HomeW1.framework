package me.max.recipesite.controllers;
import me.max.recipesite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.max.recipesite.services.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
        @PostMapping()
        public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
            recipeService.addRecipe(recipe);
            return ResponseEntity.ok(recipe);
        }

        @GetMapping("{id}")
        public ResponseEntity<Recipe> getRecipe(@PathVariable int id){
            Recipe recipe = recipeService.getRecipe(id);
            if (recipe == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(recipe);
        }

        @GetMapping
        public ResponseEntity<Recipe> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Recipe> delRecipe(@PathVariable int id) {
            recipeService.delRecipe(id);
            return ResponseEntity.notFound().build();
        }

        @PutMapping("{id}")
        public ResponseEntity<Recipe> editRecipe(@PathVariable int id,@RequestBody Recipe recipe) throws Exception {
            recipeService.editRecipe(id,recipe);
            return ResponseEntity.ok(recipe);
        }

}