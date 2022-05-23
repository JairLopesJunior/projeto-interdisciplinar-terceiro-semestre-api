package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import lombok.Data;

@Data
public class SuperHero {

    private Long id;
    private String name;
    private Powerstats powerstats;
    private Appearance appearance;
    private Biography biography;
    private Work work;
    private Connections connections;
    private Images images;
}
