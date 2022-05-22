package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/{id}")
    public SuperHero getAll(@PathVariable Long id) {
        return this.superHeroService.getById(id);
    }
}
