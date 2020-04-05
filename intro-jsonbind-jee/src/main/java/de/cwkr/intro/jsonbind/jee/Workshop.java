package de.cwkr.intro.jsonbind.jee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.json.bind.annotation.JsonbDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Workshop {
    private Long id;
    private String title;
    private LocalDate date;
    @JsonbDateFormat("HH:mm")
    private LocalTime begin;
    @JsonbDateFormat("HH:mm")
    private LocalTime end;
    private Person speaker;
    @Singular
    private List<Person> participants;
}
