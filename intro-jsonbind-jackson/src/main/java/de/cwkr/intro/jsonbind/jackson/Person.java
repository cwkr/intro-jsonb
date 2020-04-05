package de.cwkr.intro.jsonbind.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonProperty("bdate")
    private LocalDate dateOfBirth;
}
