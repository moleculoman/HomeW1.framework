package me.max.recipesite.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.max.recipesite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.max.recipesite.services.RecipeService;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD-операции и другие эндпоинты")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
        @PostMapping()
        @Operation(
                summary = "Добавление рецепта",
                description = "Метод для добавления рецепта в базу рецептов"
        )
        public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
            recipeService.addRecipe(recipe);
            return ResponseEntity.ok(recipe);
        }

        @GetMapping("{id}")
        @Operation(
                summary = "Получение рецепта по id",
                description = "Метод для получения рецепта из базы рецептов"
        )
        public ResponseEntity<Recipe> getRecipe(@PathVariable int id){
            Recipe recipe = recipeService.getRecipe(id);
            if (recipe == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(recipe);
        }

        @GetMapping
        @Operation(
                summary = "Получение всех рецептов из базы",
                description = "Метод для получения всех рецептов из базы рецептов"
        )
        public ResponseEntity<Recipe> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
        }

        @DeleteMapping("{id}")
        @Operation(
                summary = "Удаление рецепта из базы по id",
                description = "Метод для удаления рецепта из базы рецептов"
        )
        public ResponseEntity<Recipe> delRecipe(@PathVariable int id) {
            recipeService.delRecipe(id);
            return ResponseEntity.notFound().build();
        }

        @PutMapping("{id}")
        @Operation(
                summary = "Обновление рецепта по id",
                description = "Метод для обновления рецепта"
        )
        public ResponseEntity<Recipe> editRecipe(@PathVariable int id,@RequestBody Recipe recipe) throws Exception {
            recipeService.editRecipe(id,recipe);
            return ResponseEntity.ok(recipe);
        }

}