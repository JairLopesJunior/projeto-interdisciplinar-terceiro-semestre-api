package br.com.fatecararas.projetointerdisciplinar.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @NotEmpty
    @NotNull
    @Size(min = 8)
    @Column(nullable = false)
    private String repeatPassword;
}


































