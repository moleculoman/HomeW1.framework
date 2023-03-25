package me.max.recipesite.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    public boolean saveToFile (Object object, String fileName){
        Path path = Path.of(dataFilePath, fileName + ".json");
        try {
            String json = new ObjectMapper().writeValueAsString(object);
            cleanDataFile();
            Files.writeString(path,json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String readFromFile(String fileName){
        try {
            return Files.readString(Path.of(dataFilePath,fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cleanDataFile(){
        try {
            Files.deleteIfExists(Path.of(dataFilePath));
            Files.createFile(Path.of(dataFilePath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public File getDataFile(){
        return new File(dataFilePath);
    }
}