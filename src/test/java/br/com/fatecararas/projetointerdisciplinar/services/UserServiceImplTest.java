package br.com.fatecararas.projetointerdisciplinar.services;

import br.com.fatecararas.projetointerdisciplinar.config.PasswordEncoderConfig;
import br.com.fatecararas.projetointerdisciplinar.domain.entities.UserEntity;
import br.com.fatecararas.projetointerdisciplinar.dtos.UserDTO;
import br.com.fatecararas.projetointerdisciplinar.repositories.UserRepository;
import br.com.fatecararas.projetointerdisciplinar.services.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private PasswordEncoderConfig passwordEncoderConfig;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        // Cenário
        UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setEmail("fulano@gmail.com");
        createdUserDTO.setName("Fulano");
        createdUserDTO.setPassword("12345678");

        UserEntity createduser = new UserEntity();
        createduser.setEmail("fulano@gmail.com");
        createduser.setName("Fulano");
        createduser.setPassword("12345678");

        when(userRepository.save(createduser)).thenReturn(createduser);

        // Ação
        UserEntity returneduser = this.userServiceImpl.save(createdUserDTO);

        // Validação
        assertThat(returneduser, is(equalTo(createduser)));
    }
}
