package br.com.fatecararas.projetointerdisciplinar.services;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;

public interface SuperHeroPersonalizadoService {

    void save(SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO, Long idUser);

    SuperHero getById(Long idUser, Long idHero);
}
