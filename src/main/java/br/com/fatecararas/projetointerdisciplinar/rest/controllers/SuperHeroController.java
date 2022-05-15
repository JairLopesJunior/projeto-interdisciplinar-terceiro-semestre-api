package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/superherois")
public class SuperHeroController {

    private SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping
    public List<SuperHero> getAll() {
        return this.superHeroService.getAll();
    }
}
