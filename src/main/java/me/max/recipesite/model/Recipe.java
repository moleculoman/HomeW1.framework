package me.max.recipesite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;

    public Recipe(String title, int cookingTime, List<Ingredient> ingredients, List<String> steps) {
        this.title = title;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCookingTime() {
        return cookingTime;
    }
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public List<String> getSteps() {
        return steps;
    }
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
