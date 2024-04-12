package org.example.bank.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByUserId_test() throws JsonProcessingException {
        // given
        int userId = 1;

        // when
        List<Account> accountList = accountRepository.findByUserId(userId);

        // eye
        ObjectMapper om = new ObjectMapper();
        String respBody = om.writeValueAsString(accountList);
        System.out.println(respBody);

        // then
    }
}