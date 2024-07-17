package jackson.example.deserialzer;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.example.deserialzer.base.mapper.CodestableObjectMapper;
import jackson.example.deserialzer.dto.Dto;
import org.junit.jupiter.api.Test;

class DeserializationTest {

    @Test
    void deserialize() throws JsonProcessingException {

        final ObjectMapper mapper = new CodestableObjectMapper();

        testDeserializingUsingObjectMapper(mapper);
    }

    private static void testDeserializingUsingObjectMapper(final ObjectMapper mapper) throws JsonProcessingException {
        final Dto inputDto = new Dto();
        System.out.println(inputDto);

        final String jsonDataString = mapper
                //.writerWithDefaultPrettyPrinter()
                .writeValueAsString(inputDto);
        System.out.println(jsonDataString);

        final Dto deserializedDto = mapper.readValue(jsonDataString, Dto.class);
        System.out.println(deserializedDto);

        assertEquals(inputDto, deserializedDto);
    }
}

