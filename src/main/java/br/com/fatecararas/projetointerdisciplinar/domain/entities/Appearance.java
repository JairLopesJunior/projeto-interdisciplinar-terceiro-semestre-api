package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import lombok.Data;

import java.util.List;

@Data
public class Appearance {

    private String gender;
    private String race;
    private List<String> height;
    private List<String> weight;
    private String eyeColor;
    private String hairColor;

}
