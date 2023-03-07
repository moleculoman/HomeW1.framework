package me.max.recipesite.controllers;
import me.max.recipesite.model.Ingredient;
import me.max.recipesite.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity createIngredient(@PathVariable Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(ingredient);
    }
    @GetMapping("{id}")
    public ResponseEntity getIngredient(@PathVariable long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}