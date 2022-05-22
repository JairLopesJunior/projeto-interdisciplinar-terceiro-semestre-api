package br.com.fatecararas.projetointerdisciplinar.services.impl;

import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.repositories.SuperHeroPersonalizadoRepository;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroPersonalizadoService;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class SuperHeroPersonalizadoServiceImpl implements SuperHeroPersonalizadoService {

//    private final SuperHeroPersonalizadoRepository repository;
//    private SuperHeroService superHeroService;
//
//    @Autowired
//    public SuperHeroPersonalizadoServiceImpl(SuperHeroPersonalizadoRepository repository,
//                                             SuperHeroService superHeroService) {
//        this.repository = repository;
//        this.superHeroService = superHeroService;
//    }

    @Transactional
    public void save(SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO) {
//        Long firstHeroId = superHeroPersonalizadoDTO.getFirstHeroId();
//        Long secondHeroId = superHeroPersonalizadoDTO.getSecondHeroId();
//        List<SuperHero> heroes = getSuperHeroesCustom(firstHeroId, secondHeroId);
//
//        return;
    }

//    private List<SuperHero> getSuperHeroesCustom(Long firstHeroId, Long secondHeroId) {
//        List<SuperHero> heroes = new ArrayList<>();
//        SuperHero firstHero = this.superHeroService.getById(firstHeroId);
//        SuperHero secondHero = this.superHeroService.getById(secondHeroId);
//        heroes.add(firstHero);
//        heroes.add(secondHero);
//        return heroes;
//    }
}
