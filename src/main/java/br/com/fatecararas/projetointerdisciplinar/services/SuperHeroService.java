package br.com.fatecararas.projetointerdisciplinar.services;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.exception.NotFoundException;
import br.com.fatecararas.projetointerdisciplinar.feign.SuperHeroFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService {

    private SuperHeroFeignClient feign;
    private List<SuperHero> allSuperHeroes;

    @Autowired
    public SuperHeroService(SuperHeroFeignClient feign) {
        this.feign = feign;
    }

    public List<SuperHero> getAll() {
        List<SuperHero> superHeroes = this.feign.getAll();
        this.allSuperHeroes = superHeroes;
        return superHeroes;
    }

    public SuperHero getById(Long id) {
        var superHeroes = this.allSuperHeroes.isEmpty() ? this.getAll() : this.allSuperHeroes;
        var superHeroFound = this.getSuperHeroById(superHeroes, id);
        return superHeroFound;
    }

    private SuperHero getSuperHeroById(List<SuperHero> superHeroes, Long id) {
        return superHeroes
                .stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("SuperHero not found."));
    }
}
