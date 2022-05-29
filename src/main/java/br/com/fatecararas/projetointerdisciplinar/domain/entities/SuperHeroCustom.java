package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
})
@Table(name = "super_hero_custom")
public class SuperHeroCustom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "increment")
    //@GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String superHeroCustom;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_User")
    private UserEntity user;
}
