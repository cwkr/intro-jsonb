package de.cwkr.intro.jsonbind.jee;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonbProperty("bdate")
    private LocalDate dateOfBirth;
}
