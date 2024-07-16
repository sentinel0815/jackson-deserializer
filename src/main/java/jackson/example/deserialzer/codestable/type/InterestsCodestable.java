package jackson.example.deserialzer.codestable.type;

import jackson.example.deserialzer.codestable.base.AbstractCodestable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// generated class
public class InterestsCodestable extends AbstractCodestable {
    public static final String CATEGORY = "INTEREST";

    public static final InterestsCodestable SPORT = new InterestsCodestable("1");
    public static final InterestsCodestable READING = new InterestsCodestable("2");
    // etc.

    private static final Map<String, InterestsCodestable> BY_CODE = initCache();

    private InterestsCodestable(final String code) {
        super(CATEGORY, code);
    }

    private static Map<String, InterestsCodestable> initCache() {
        final InterestsCodestable[] values = new InterestsCodestable[] {SPORT, READING};
        final Map<String, InterestsCodestable> map = new HashMap<>();
        for (final InterestsCodestable e : values) {
            map.put(e.getCode(), e);
        }
        return Collections.unmodifiableMap(map);
    }

    public static InterestsCodestable valueOf(final String code) {
        if (BY_CODE.containsKey(code)) {
            return BY_CODE.get(code);
        } else {
            throw new NoSuchElementException("No InterestsCodestable found with the code: " + code);
        }
    }
}
