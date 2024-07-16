package jackson.example.deserialzer.codestable.type;

import jackson.example.deserialzer.base.codestable.AbstractCodestable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// generated class
public class SalutationCodestable extends AbstractCodestable {
    public static final String CATEGORY = "SALUTATION";

    public static final SalutationCodestable MRS = new SalutationCodestable("1");
    public static final SalutationCodestable MR = new SalutationCodestable("2");
    // etc.

    private static final Map<String, SalutationCodestable> BY_CODE = initCache();

    private SalutationCodestable(final String code) {
        super(CATEGORY, code);
    }

    private static Map<String, SalutationCodestable> initCache() {
        final SalutationCodestable[] values = new SalutationCodestable[] {MRS, MR};
        final Map<String, SalutationCodestable> map = new HashMap<>();
        for (final SalutationCodestable e : values) {
            map.put(e.getCode(), e);
        }
        return Collections.unmodifiableMap(map);
    }

    public static SalutationCodestable valueOf(final String code) {
        if (BY_CODE.containsKey(code)) {
            return BY_CODE.get(code);
        } else {
            throw new NoSuchElementException("No SalutationCodestable found with the code: " + code);
        }
    }
}
