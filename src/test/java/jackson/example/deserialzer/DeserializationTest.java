package jackson.example.deserialzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.example.deserialzer.dto.Dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionalOutboxSerializationTest {

    @Test
    void deserialize() throws JsonProcessingException {

        final ObjectMapper mapper = new ObjectMapper();

        final Dto inputDto = new Dto();

        final String jsonDataString = mapper.writeValueAsString(inputDto);
        System.out.println(jsonDataString);

        final Dto deserializedDto = mapper.readValue(jsonDataString, Dto.class);
        System.out.println(deserializedDto);

        Assertions.assertEquals(inputDto, deserializedDto);
    }
}

