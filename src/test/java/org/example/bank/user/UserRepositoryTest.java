package org.example.bank.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test() {
        // given
        String username = "ssar";
        String password = "1234";

        // when
        Optional<User> userOP = userRepository.findByUsernameAndPassword(username, password);

        // eye
        //  User user = userOP.get();
        //  System.out.println("findByUsernameAndPassword: " + user.getUsername());

        // then
        Assertions.assertThat(userOP.get()).isNotNull();
    }
}
