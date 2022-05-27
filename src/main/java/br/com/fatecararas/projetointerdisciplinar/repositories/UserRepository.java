package br.com.fatecararas.projetointerdisciplinar.repositories;

import br.com.fatecararas.projetointerdisciplinar.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);

    Boolean existsByEmail(String email);

    Optional<User> findById(Long idUser);
}
