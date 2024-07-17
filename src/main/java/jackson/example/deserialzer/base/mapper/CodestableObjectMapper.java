package jackson.example.deserialzer.base.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jackson.example.deserialzer.base.codestable.AbstractCodestable;
import jackson.example.deserialzer.base.codestable.Codestable;
import jackson.example.deserialzer.codestable.type.GenderCodestable;
import jackson.example.deserialzer.codestable.type.InterestsCodestable;

public class CodestableObjectMapper extends ObjectMapper {

    public CodestableObjectMapper() {
        super();

        // add configuration here


        super//.configure(MapperFeature.USE_STATIC_TYPING, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }
}
