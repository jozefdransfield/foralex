package santander;

import santander.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class CSVMessageParser implements MessageParser {

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");

    public List<Price> parse(String message) {
        return splitMessageIntoLines(message).map(parseIntoPrice()).toList();
    }

    private Function<String, Price> parseIntoPrice() {
        return line -> {
            List<String> parts = Arrays.stream(line.split(",")).map(String::trim).toList();
            return new Price(parts.get(0), parts.get(1), new BigDecimal(parts.get(2)), new BigDecimal(parts.get(3)), LocalDateTime.parse(parts.get(4), dateTimeFormatter));
        };
    }

    private Stream<String> splitMessageIntoLines(String message) {
        return Arrays.stream(message.split("\n"));
    }
}
