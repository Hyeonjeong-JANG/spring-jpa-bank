package org.example.bank.history;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class HistoryRepositoryTest {
    @Autowired
    private HistoryRepository historyRepository;

    @Test
    public void findBySenderOrReceiver_test() throws JsonProcessingException {
        // given
        int number = 1111;

        // when
        List<History> historyList =
                historyRepository.findBySenderOrReceiver(number);

        // eye
        ObjectMapper om = new ObjectMapper();
        String respBody = om.writeValueAsString(historyList);
        System.out.println(respBody);


        // then
    }
}