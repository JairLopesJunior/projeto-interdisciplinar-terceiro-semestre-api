package br.com.fatecararas.projetointerdisciplinar.services.impl;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.Appearance;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.Powerstats;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.SuperHero;
import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroPersonalizadoService;
import br.com.fatecararas.projetointerdisciplinar.services.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static br.com.fatecararas.projetointerdisciplinar.domain.entities.Appearance.*;
import static br.com.fatecararas.projetointerdisciplinar.domain.entities.Powerstats.*;

@Transactional(readOnly = true)
@Service
public class SuperHeroPersonalizadoServiceImpl implements SuperHeroPersonalizadoService {

//    private final SuperHeroPersonalizadoRepository repository;
    private SuperHeroService superHeroService;

    @Autowired
    public SuperHeroPersonalizadoServiceImpl(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @Transactional
    public void save(SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO) {
        Long firstHeroId = superHeroPersonalizadoDTO.getFirstHeroId();
        Long secondHeroId = superHeroPersonalizadoDTO.getSecondHeroId();
        String eyeColor = superHeroPersonalizadoDTO.getEyeColor();
        String hairColor = superHeroPersonalizadoDTO.getHairColor();

        List<SuperHero> heroes = getSuperHeroesCustom(firstHeroId, secondHeroId);
        Powerstats powerstats = this.getPowerstats(heroes);
        Appearance appearance = this.getAppearance(heroes, eyeColor, hairColor);


        SuperHero newSuperHero = new SuperHero();
        String fullName = superHeroPersonalizadoDTO.getFullName();
        newSuperHero.setName(fullName);
        newSuperHero.setPowerstats(powerstats);

        return;
    }

    private List<SuperHero> getSuperHeroesCustom(Long firstHeroId, Long secondHeroId) {
        List<SuperHero> heroes = new ArrayList<>();
        SuperHero firstHero = this.superHeroService.getById(firstHeroId);
        SuperHero secondHero = this.superHeroService.getById(secondHeroId);
        heroes.add(firstHero);
        heroes.add(secondHero);
        return heroes;
    }

    private Powerstats getPowerstats(List<SuperHero> heroes) {
        List<Powerstats> powers = getAllPowerstats(heroes);
        if(!powers.isEmpty()) {
            return null;
        }
        Double intelligence = getAverageIntelligence(powers);
        Double strength = getAverageStrength(powers);
        Double speed = getAverageSpeed(powers);
        Double durability = getAverageDurability(powers);
        Double power = getAveragePower(powers);
        Double combat = getAverageCombat(powers);

        Powerstats powerstats = new Powerstats();
        return powerstats.builder()
                .intelligence(intelligence)
                .strength(strength)
                .speed(speed)
                .durability(durability)
                .power(power)
                .combat(combat)
                .build();
    }

    private Appearance getAppearance(List<SuperHero> heroes, String eyeColor, String hairColor) {
        List<Appearance> appearance = getAllAppearance(heroes);
        if(!appearance.isEmpty()) {
            return null;
        }

        Double height = getAverageSecondHeight(appearance);
        Double weight = getAverageSecondWeight(appearance);

        Appearance.builder()
        //        .height(height)
        //        .weight(weight)
                .eyeColor(eyeColor)
                .hairColor(hairColor)
                .build();
        return null;
    }

}
