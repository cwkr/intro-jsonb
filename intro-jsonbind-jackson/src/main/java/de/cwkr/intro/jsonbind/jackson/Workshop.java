package de.cwkr.intro.jsonbind.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder(setterPrefix = "with")
public class Workshop {
    private Long id;
    private String title;
    private LocalDate date;
    @JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
    private LocalTime begin;
    @JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
    private LocalTime end;
    private Person speaker;
    @Singular
    private List<Person> participants;
}
