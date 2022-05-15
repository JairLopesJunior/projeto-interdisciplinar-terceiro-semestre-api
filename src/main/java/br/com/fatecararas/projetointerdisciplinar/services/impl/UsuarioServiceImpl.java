package br.com.fatecararas.projetointerdisciplinar.services.impl;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.Usuario;
import br.com.fatecararas.projetointerdisciplinar.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var foundUser = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        return User
                .builder()
                .username(foundUser.getEmail())
                .password(foundUser.getPassword())
                .roles("ADMIN")
                .build();
    }
}



































