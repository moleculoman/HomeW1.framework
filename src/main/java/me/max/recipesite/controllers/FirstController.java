package me.max.recipesite.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

class Person {
    public String name = "Maxim";
    public String projectName = "RecipeSiteAPP";
    public String LocalDateTime;
    public String description = "Сайт с рецептами";

    @RestController
    public class FirstController {

        @GetMapping("/")
        public String helloWeb() {
            return "Приложение запущено";
        }

        @GetMapping("/info")
        public String oneStudent() {
            return name + " " + projectName + " "+ LocalDateTime+ " " + description;
        }
    }
}
