package de.cwkr.intro.jsonbind.jee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;
import org.junit.jupiter.api.Test;

public class WorkshopTest {
    private final Jsonb jsonb = JsonbBuilder.create(
        new JsonbConfig().withFormatting(true)
                         .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL)
    );

    private static final String JSON_DATA = "{\"id\":7,\"title\":\"Some Workshop\",\"date\":\"2020-04-06\",\"begin\":\"08:30\",\"end\":\"17:00\","
        + "\"speaker\":{\"id\":11,\"firstName\":\"Jane\",\"lastName\":\"Boss\",\"bdate\":\"1989-12-20\"},"
        + "\"participants\":[{\"id\":42,\"firstName\":\"Jim\",\"lastName\":\"Test\",\"bdate\":\"1978-01-05\"},"
        + "{\"id\":23,\"firstName\":\"Sam\",\"lastName\":\"Sample\",\"bdate\":\"1982-03-10\"}]}";

    @Test
    public void toJson() {
        Workshop workshop = Workshop.builder()
                                    .withId(7L)
                                    .withTitle("Some Workshop")
                                    .withDate(LocalDate.of(2020, Month.APRIL, 6))
                                    .withBegin(LocalTime.of(8, 30))
                                    .withEnd(LocalTime.of(17, 0))
                                    .withSpeaker(
                                        Person.builder()
                                              .withId(11L)
                                              .withFirstName("Jane")
                                              .withLastName("Boss")
                                              .withDateOfBirth(LocalDate.of(1989, Month.DECEMBER, 20))
                                              .build()
                                    )
                                    .withParticipant(
                                        Person.builder()
                                              .withId(42L)
                                              .withFirstName("Jim")
                                              .withLastName("Test")
                                              .withDateOfBirth(LocalDate.of(1978, Month.JANUARY, 5))
                                              .build()
                                    )
                                    .withParticipant(
                                        Person.builder()
                                              .withId(23L)
                                              .withFirstName("Sam")
                                              .withLastName("Sample")
                                              .withDateOfBirth(LocalDate.of(1982, Month.MARCH, 10))
                                              .build()
                                    )
                                    .build();
        System.out.println(workshop);
        System.out.println(jsonb.toJson(workshop));
    }

    @Test
    public void fromJson() {
        Workshop workshop = jsonb.fromJson(JSON_DATA, Workshop.class);
        System.out.println(workshop);
    }
}
