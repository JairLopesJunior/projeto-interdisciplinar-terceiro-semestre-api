package br.com.fatecararas.projetointerdisciplinar.services;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.feign.SuperHeroFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService {

    private SuperHeroFeignClient feign;

    @Autowired
    public SuperHeroService(SuperHeroFeignClient feign) {
        this.feign = feign;
    }

    public List<SuperHero> getAll() {
        return this.feign.getAll();
    }
}
