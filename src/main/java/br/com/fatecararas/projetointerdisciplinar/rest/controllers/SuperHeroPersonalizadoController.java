package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHeroCustom;
import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroPersonalizadoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
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

    @GetMapping("/{idUser}/superheroescustom/{id}")
    public SuperHeroPersonalizadoDTO getById(@PathVariable Long idUser, @PathVariable Long idHero) {
        SuperHeroCustom superHeroCustom = this.service.getById(idUser, idHero);
        Gson gson = new Gson();
        SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO = gson.fromJson(superHeroCustom.getSuperHeroCustom(), SuperHeroPersonalizadoDTO.class);
        return superHeroPersonalizadoDTO;
    }
}
