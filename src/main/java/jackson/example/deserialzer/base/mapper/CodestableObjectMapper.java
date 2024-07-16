package jackson.example.deserialzer.base.mapper;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jackson.example.deserialzer.codestable.type.GenderCodestable;
import jackson.example.deserialzer.codestable.type.InterestsCodestable;

public class CodestableObjectMapper extends ObjectMapper {

    public CodestableObjectMapper() {
        super();

        // add configuration here

        final PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("java.lang.Object")
                .allowIfSubType("jackson.example.deserialzer.")
                //.allowIfSubTypeIsArray()
                .build();
        super.activateDefaultTyping(ptv, DefaultTyping.NON_FINAL);


        final SimpleModule module = new SimpleModule();
        CodestableDeserializer ctdeser = new CodestableDeserializer();
        module.addDeserializer(GenderCodestable.class, ctdeser);
        module.addDeserializer(InterestsCodestable.class, ctdeser);
        super.registerModules(module);

        super.configure(MapperFeature.USE_STATIC_TYPING, true);

    }
}
