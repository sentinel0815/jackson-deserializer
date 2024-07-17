package jackson.example.deserialzer.dto;

import jackson.example.deserialzer.codestable.type.GenderCodestable;
import jackson.example.deserialzer.codestable.type.InterestsCodestable;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dto {

    private String foo = "bar";

    private GenderCodestable genderChoice = GenderCodestable.FEMALE;

    private List<InterestsCodestable> hobbies = List.of(InterestsCodestable.READING, InterestsCodestable.SPORT);
}
