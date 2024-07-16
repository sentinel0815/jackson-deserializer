package jackson.example.deserialzer.base.codestable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "_class")
public abstract class AbstractCodestable implements Codestable {

    private final String category;
    private final String code;
}

