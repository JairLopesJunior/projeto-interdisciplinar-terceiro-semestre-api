package br.com.fatecararas.projetointerdisciplinar.rest.controllers;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.Usuario;
import br.com.fatecararas.projetointerdisciplinar.dtos.LoginDTO;
import br.com.fatecararas.projetointerdisciplinar.dtos.UsuarioDTO;
import br.com.fatecararas.projetointerdisciplinar.response.LoginResponse;
import br.com.fatecararas.projetointerdisciplinar.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioServiceImpl usuarioService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        this.validPassword(usuarioDTO.getPassword(), usuarioDTO.getRepeatPassword());
        String encryptedPassword = passwordEncoder.encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(encryptedPassword);
        return usuarioService.save(usuarioDTO);
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        return usuarioService.login(email, password);
    }

    private void validPassword(String password, String repeatPassword) {
        if(!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("As senhas estão divergentes.");
        }
    }
}
