package jackson.example.deserialzer.codestable.base;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractCodestable implements Codestable {

    private final String category;
    private final String code;
}

