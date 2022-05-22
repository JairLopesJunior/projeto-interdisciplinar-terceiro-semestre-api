package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroPersonalizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/superheroes/custom")
public class SuperHeroPersonalizadoController {

    private SuperHeroPersonalizadoService service;

    @Autowired
    public SuperHeroPersonalizadoController(SuperHeroPersonalizadoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO) {
        this.service.save(superHeroPersonalizadoDTO);
    }
}
