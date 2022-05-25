package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroPersonalizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class SuperHeroPersonalizadoController {

    private SuperHeroPersonalizadoService service;

    @Autowired
    public SuperHeroPersonalizadoController(SuperHeroPersonalizadoService service) {
        this.service = service;
    }

    @PostMapping("/{idUser}/superheroescustom")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO, @PathVariable Long idUser) {
        this.service.save(superHeroPersonalizadoDTO, idUser);
    }

    @GetMapping("/{idUser}/superheroescustom/{idHero}")
    public SuperHero getById(@PathVariable Long idUser, @PathVariable Long idHero) {
        return this.service.getById(idUser, idHero);
    }
}