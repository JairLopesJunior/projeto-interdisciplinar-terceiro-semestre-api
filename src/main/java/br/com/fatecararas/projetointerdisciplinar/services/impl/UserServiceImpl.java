package br.com.fatecararas.projetointerdisciplinar.services.impl;

import br.com.fatecararas.projetointerdisciplinar.config.PasswordEncoderConfig;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.User;
import br.com.fatecararas.projetointerdisciplinar.dtos.UserDTO;
import br.com.fatecararas.projetointerdisciplinar.repositories.UserRepository;
import br.com.fatecararas.projetointerdisciplinar.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository usuarioRepository;
    private PasswordEncoderConfig passwordEncoderConfig;

    @Autowired
    public UserServiceImpl(UserRepository usuarioRepository, PasswordEncoderConfig passwordEncoderConfig) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    @Transactional
    public User save(UserDTO usuarioDTO) {
        User usuario = new User();
        usuario.setName(usuarioDTO.getName());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuarioRepository.save(usuario);
    }

    public LoginResponse login(String email, String password) {
        User foundUser = usuarioRepository.findByEmail(email)
                        .orElseThrow(() -> new IllegalArgumentException("The email or password fields are incorrect."));
        String userPasswordFound = foundUser.getPassword();
        Long userId = foundUser.getId();
        validPassword(userPasswordFound, password);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(userId);
        return loginResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var foundUser = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in database."));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(foundUser.getEmail())
                .password(foundUser.getPassword())
                .roles("ADMIN")
                .build();
    }

    private void validPassword(String userPasswordFound, String password) {
        if(!passwordEncoderConfig.passwordEncoder().matches(password, userPasswordFound)) {
            throw new IllegalArgumentException("The email or password fields are incorrect.");
        }
    }
}



































