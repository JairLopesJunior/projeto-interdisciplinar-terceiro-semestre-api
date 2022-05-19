package br.com.fatecararas.projetointerdisciplinar.services.impl;

import br.com.fatecararas.projetointerdisciplinar.config.PasswordEncoderConfig;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.Usuario;
import br.com.fatecararas.projetointerdisciplinar.dtos.UsuarioDTO;
import br.com.fatecararas.projetointerdisciplinar.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoderConfig passwordEncoderConfig;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoderConfig passwordEncoderConfig) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    @Transactional
    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioDTO.getName());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuarioRepository.save(usuario);
    }

    public Integer login(String email, String password) {
        Usuario foundUser = usuarioRepository.findByEmail(email)
                        .orElseThrow(() -> new IllegalArgumentException("E-mail incorreto."));
        String userPasswordFound = foundUser.getPassword();
        Integer userId = foundUser.getId();
        validPassword(userPasswordFound, password);
        return userId;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var foundUser = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        return User
                .builder()
                .username(foundUser.getEmail())
                .password(foundUser.getPassword())
                .roles("ADMIN")
                .build();
    }

    private void validPassword(String userPasswordFound, String password) {
        if(!passwordEncoderConfig.passwordEncoder().matches(password, userPasswordFound)) {
            throw new IllegalArgumentException("Password incorreto.");
        }
    }
}



































