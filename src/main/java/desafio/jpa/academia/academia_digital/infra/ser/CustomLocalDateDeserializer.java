package desafio.jpa.academia.academia_digital.infra.ser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> { // ✅ LocalDate

    public static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"),
            DateTimeFormatter.ISO_LOCAL_DATE
    );

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctx) // ✅ LocalDate
            throws IOException {
        String value = p.getText().trim();
        for (DateTimeFormatter fmt : FORMATTERS) {
            try {
                return LocalDate.parse(value, fmt); // ✅ LocalDate
            } catch (DateTimeParseException ignored) {}
        }
        throw new IOException("Formato de data inválido: " + value);
    }
}