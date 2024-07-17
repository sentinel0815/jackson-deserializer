package jackson.example.deserialzer.codestable.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jackson.example.deserialzer.base.codestable.AbstractCodestable;
import lombok.ToString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// generated class
public class GenderCodestable extends AbstractCodestable {
    public static final String CATEGORY = "GENDER";

    public static final GenderCodestable FEMALE = new GenderCodestable("1");
    public static final GenderCodestable MALE = new GenderCodestable("2");
    // etc.

    private static final Map<String, GenderCodestable> BY_CODE = initCache();

    private GenderCodestable(final String code) {
        super(CATEGORY, code);
    }

    private static Map<String, GenderCodestable> initCache() {
        final GenderCodestable[] values = new GenderCodestable[] {FEMALE, MALE};
        final Map<String, GenderCodestable> map = new HashMap<>();
        for (final GenderCodestable e : values) {
            map.put(e.getCode(), e);
        }
        return Collections.unmodifiableMap(map);
    }

    @JsonCreator
    public static GenderCodestable valueOf(final @JsonProperty("code") String code) {
        if (BY_CODE.containsKey(code)) {
            return BY_CODE.get(code);
        } else {
            throw new NoSuchElementException("No GenderCodestable found with the code: " + code);
        }
    }
}
