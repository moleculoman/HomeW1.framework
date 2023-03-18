package me.max.recipesite.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class RecipeFilesService{

    @Value("${path.to.data.file}")
    private String recipesFilePath;

    @Value("${name.of.recipes.file}")
    private String recipesFileName;

    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(recipesFilePath, recipesFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String readFromFile() {
        try {
            return Files.readString(Path.of(recipesFilePath, recipesFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getDataFile() {
        return new File(recipesFilePath + "/" + recipesFileName);
    }

    public boolean cleanDataFile() {
        try {
            Path path = Path.of(recipesFilePath, recipesFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
