package br.com.fatecararas.projetointerdisciplinar.repositories;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
