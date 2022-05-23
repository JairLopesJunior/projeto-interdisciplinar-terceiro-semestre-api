package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Powerstats {

    private Double intelligence;
    private Double strength;
    private Double speed;
    private Double durability;
    private Double power;
    private Double combat;

    public static List<Powerstats> getAllPowerstats(List<SuperHero> heroes) {
        return heroes
                .stream()
                .map(hero -> hero.getPowerstats())
                .collect(Collectors.toList());
    }

    public static Double getAverageIntelligence(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getIntelligence())
                .mapToDouble(intelligence -> intelligence)
                .average()
                .getAsDouble();
    }

    public static Double getAverageStrength(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getStrength())
                .mapToDouble(strength -> strength)
                .average()
                .getAsDouble();
    }

    public static Double getAverageSpeed(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getSpeed())
                .mapToDouble(speed -> speed)
                .average()
                .getAsDouble();
    }

    public static Double getAverageDurability(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getDurability())
                .mapToDouble(durability -> durability)
                .average()
                .getAsDouble();
    }

    public static Double getAveragePower(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getPower())
                .mapToDouble(power -> power)
                .average()
                .getAsDouble();
    }

    public static Double getAverageCombat(List<Powerstats> powers) {
        return powers
                .stream()
                .map(power -> power.getCombat())
                .mapToDouble(combat -> combat)
                .average()
                .getAsDouble();
    }
}
