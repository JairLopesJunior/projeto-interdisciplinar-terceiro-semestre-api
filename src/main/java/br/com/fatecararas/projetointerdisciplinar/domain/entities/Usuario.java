package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @NotNull
    @Column(length = 50,nullable = false)
    private String name;

    @NotEmpty
    @NotNull
    @Email
    @Column(length = 80,nullable = false, unique = true)
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 8, message = "A senha deve conter no minímo {min} caracteres")
    @Column(nullable = false)
    private String password;
}


































