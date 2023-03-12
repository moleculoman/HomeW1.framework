package me.max.recipesite.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
    @RestController
    @Tag(name = "Проверка работоспособности приложения", description = "CRUD-операции и другие эндпоинты")
    public class FirstController {
    @RequestMapping("/")
        @GetMapping
        public String helloWeb() {
            return "Приложение запущено";
        }
        @GetMapping("/info")
        @Operation(
                summary = "Получение данных о сайте",
                description = "Метод для получения данных о сайте"
        )
        public String oneStudent() {
            return "Maxim," + " RecipeSiteAPP," + " Сайт с рецептами";
        }
    }