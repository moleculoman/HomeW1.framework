package me.max.recipesite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingredient {
    private String ingredName;
    private int amount;
    private String measure;

    public Ingredient(String ingredName, int amount, String measure) {
        this.ingredName = ingredName;
        this.amount = amount;
        this.measure = measure;
    }

    public String getIngredName() {
        return ingredName;
    }

    public void setIngredName(String name) {
        this.ingredName = ingredName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
