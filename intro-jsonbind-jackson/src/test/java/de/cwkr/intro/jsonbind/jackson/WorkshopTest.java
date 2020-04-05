package de.cwkr.intro.jsonbind.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import org.junit.jupiter.api.Test;

public class WorkshopTest {
    private final ObjectMapper objectMapper = new ObjectMapper()
        .enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
        .findAndRegisterModules();

    private static final String JSON_DATA = "{\"id\":7,\"title\":\"Some Workshop\",\"date\":\"2020-04-06\",\"begin\":\"08:30\",\"end\":\"17:00\","
        + "\"speaker\":{\"id\":11,\"firstName\":\"Jane\",\"lastName\":\"Boss\",\"bdate\":\"1989-12-20\"},"
        + "\"participants\":[{\"id\":42,\"firstName\":\"Jim\",\"lastName\":\"Test\",\"bdate\":\"1978-01-05\"},"
        + "{\"id\":23,\"firstName\":\"Sam\",\"lastName\":\"Sample\",\"bdate\":\"1982-03-10\"}]}";

    @Test
    public void toJson() throws IOException {
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
        System.out.println(objectMapper.writeValueAsString(workshop));
    }

    @Test
    public void fromJson() throws JsonProcessingException {
        Workshop workshop = objectMapper.readValue(JSON_DATA, Workshop.class);
        System.out.println(workshop);
    }
}
