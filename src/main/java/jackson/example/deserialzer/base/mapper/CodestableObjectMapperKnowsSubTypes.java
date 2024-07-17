package jackson.example.deserialzer.base.mapper;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jackson.example.deserialzer.base.codestable.AbstractCodestable;
import jackson.example.deserialzer.base.codestable.Codestable;
import jackson.example.deserialzer.codestable.type.GenderCodestable;
import jackson.example.deserialzer.codestable.type.InterestsCodestable;

public class CodestableObjectMapperKnowsSubTypes extends ObjectMapper {

    public CodestableObjectMapperKnowsSubTypes() {
        super();

        // add configuration here

        final PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("jackson.example.deserialzer.")
                .allowIfBaseType("java.util.List")
                .build();
        super.activateDefaultTyping(ptv, DefaultTyping.NON_FINAL);


        final SimpleModule module = new SimpleModule();
        CodestableDeserializer ctdeser = new CodestableDeserializer();
        module.addDeserializer(Codestable.class, ctdeser);
        module.addDeserializer(AbstractCodestable.class, ctdeser);
        // In real the concrete codestable implementation classes are not known in 'base'
        module.addDeserializer(GenderCodestable.class, ctdeser);
        module.addDeserializer(InterestsCodestable.class, ctdeser);
        super.registerModules(module);

        super.configure(MapperFeature.USE_STATIC_TYPING, true);

    }
}
