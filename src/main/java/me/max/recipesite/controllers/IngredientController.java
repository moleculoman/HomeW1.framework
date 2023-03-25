package me.max.recipesite.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.max.recipesite.model.Ingredient;
import me.max.recipesite.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ингредиенты", description = "CRUD-операции и другие эндпоинты")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping()
    @Operation(
            summary = "Добавление ингредиента по id",
            description = "Метод для добавления рецепта в базу ингредиентов"
    )
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Обновление ингредиента по id",
            description = "Метод для обновления ингредиента"
    )
    public ResponseEntity<Ingredient> editIngredient(@PathVariable int id,@RequestBody Ingredient ingredient) throws Exception {
        ingredientService.editIngredient(id,ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Удаление ингредиента из базы по id",
            description = "Метод для удаления ингредиента из базы ингредиентов"
    )
    public ResponseEntity<Integer> delIngredient(@PathVariable int id){
        ingredientService.delIngredient(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Получение ингредиента по id",
            description = "Метод для получения ингредиента из базы ингредиентов"
    )
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    @Operation(
            summary = "Получение всех ингредиентов из базы",
            description = "Метод для получения всех ингредиентов из базы ингредиентов"
    )
    public ResponseEntity<Ingredient> getAllIngredients(){
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }
}