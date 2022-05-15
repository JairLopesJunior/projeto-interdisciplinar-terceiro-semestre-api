package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.Usuario;
import br.com.fatecararas.projetointerdisciplinar.services.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody @Valid Usuario usuario) {
        String encryptedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encryptedPassword);
        return usuarioService.save(usuario);
    }
}
