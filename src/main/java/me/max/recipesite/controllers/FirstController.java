package me.max.recipesite.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

    @RestController
    public class FirstController {
    @RequestMapping
        @GetMapping("/")
        public String helloWeb() {
            return "Приложение запущено";
        }
        @GetMapping("/info")
        public String oneStudent() {
            return "Maxim," + " RecipeSiteAPP," + " Сайт с рецептами";
        }
    }