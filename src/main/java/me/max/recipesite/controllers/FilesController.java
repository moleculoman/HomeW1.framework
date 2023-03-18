/*

package me.max.recipesite.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.max.recipesite.services.FilesService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files")
@Tag(name = "Файлы", description = "CRUD-операции и другие эндпоинты")
public class FilesController {
    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping("/export/recipes")
    @Operation(
            summary = "Выгрузка файла",
            description = "Метод для получения файла"
    )
    public ResponseEntity<InputStreamResource> downloadFile() throws FileNotFoundException {
        File file = filesService.getDataFile();
        if (file.exists()){
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}


*/