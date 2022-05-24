package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Data
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
@Table(name = "super_hero_custom")
public class SuperHeroCustom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition = "json")
    private String superHeroCustom;

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;
}
