package me.max.recipesite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingredient {
    private String title;
    private int amount;
    private String measure;

    public Ingredient(String title, int amount, String measure) {
        this.title = title;
        this.amount = amount;
        this.measure = measure;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
