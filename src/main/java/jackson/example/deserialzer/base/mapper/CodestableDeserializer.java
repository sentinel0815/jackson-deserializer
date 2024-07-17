package jackson.example.deserialzer.base.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import jackson.example.deserialzer.base.codestable.AbstractCodestable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CodestableDeserializer<T extends AbstractCodestable> extends StdDeserializer<T> {

    public CodestableDeserializer() {
        this(null);
    }

    public CodestableDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public T deserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        final String className = node.get("_class").asText();
        final String code = node.get("code").asText();

        try {
            // How to read type class info?
            final Class<T> clazz = (Class<T>) Class.forName(className);
            final Method valueOfMethod = clazz.getMethod("valueOf", String.class);
            return (T) valueOfMethod.invoke(null, code);
        } catch (final ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}