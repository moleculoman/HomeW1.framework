package me.max.recipesite.services;

import java.io.File;

public interface IngredientFilesServiceInter {
    boolean saveToFile(String json);

    String readFromFile();

    File getDataFile();

    boolean cleanDataFile();
}
