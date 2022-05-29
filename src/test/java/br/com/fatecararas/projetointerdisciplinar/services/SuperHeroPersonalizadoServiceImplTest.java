package br.com.fatecararas.projetointerdisciplinar.services;

import br.com.fatecararas.projetointerdisciplinar.dtos.SuperHeroPersonalizadoDTO;
import br.com.fatecararas.projetointerdisciplinar.repositories.UserRepository;
import br.com.fatecararas.projetointerdisciplinar.services.impl.SuperHeroPersonalizadoServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SuperHeroPersonalizadoServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SuperHeroPersonalizadoServiceImpl superHeroPersonalizadoService;

    @Before
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveWithUserNotFound() {
        // Cenário
        Long idUser = 1L;

        when(this.userRepository.findById(idUser)).thenReturn(Optional.empty());

        // Ação e Validação
        UsernameNotFoundException returnedException = assertThrows(UsernameNotFoundException.class,
                () -> superHeroPersonalizadoService.save(any(), idUser));

        // Validação
        assertThat(returnedException.getMessage(), is(equalTo("User not found in database.")));
    }

    @Test
    void saveWithUserNotFoundas() {
        // Cenário
        SuperHeroPersonalizadoDTO superHeroPersonalizadoDTO = new SuperHeroPersonalizadoDTO();
        superHeroPersonalizadoDTO.setFullName("Iron Man");
        superHeroPersonalizadoDTO.setNickName("Tony Stark");
        superHeroPersonalizadoDTO.setEyeColor("Clack");
        superHeroPersonalizadoDTO.setHairColor("Black");
        superHeroPersonalizadoDTO.setProfession("VASP");
        superHeroPersonalizadoDTO.setFirstApparition("SLA");
        superHeroPersonalizadoDTO.setPublishedBy("Marvel");
        superHeroPersonalizadoDTO.setImage("imagem");
        superHeroPersonalizadoDTO.setFirstHeroId(1L);
        superHeroPersonalizadoDTO.setSecondHeroId(2L);

        Long idUser = 1L;

        when().thenReturn();

        // Ação
    }
}
