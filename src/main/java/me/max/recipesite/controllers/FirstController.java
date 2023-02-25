package me.max.recipesite.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FirstController {

    @GetMapping()
    public String helloWeb(){
        return "Приложение запущено";
    }
}
