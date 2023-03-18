package me.max.recipesite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.max.recipesite.services.RecipeFilesService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/recipe/files")
@Tag(name = "Файловый контроллер для рецептов", description = "Операции с файлами рецептами")
public class RecipeFilesController {
    private final RecipeFilesService recipeFilesService;

    public RecipeFilesController(RecipeFilesService recipeFilesService) {
        this.recipeFilesService = recipeFilesService;
    }

    @GetMapping("export")
    @Operation(
            summary = "Скачивание файла с рецептами",
            description = "Метод для скачки файла"
    )
    public ResponseEntity<InputStreamResource> downloadDataFile() throws FileNotFoundException {
        File file = recipeFilesService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"AllRecipes.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла с рецептами",
            description = "Метод для загрузки файла"
    )
    public ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file) {
        recipeFilesService.cleanDataFile();
        File dataFile = recipeFilesService.getDataFile();
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
