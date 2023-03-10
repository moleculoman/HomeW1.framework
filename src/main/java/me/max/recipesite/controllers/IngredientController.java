package me.max.recipesite.controllers;
import me.max.recipesite.model.Ingredient;
import me.max.recipesite.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping()
    public ResponseEntity<Ingredient> addIngredient(@PathVariable Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable int id,@RequestBody Ingredient ingredient){
        ingredientService.editIngredient(id,ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delIngredient(@PathVariable int id){
        ingredientService.delIngredient(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}