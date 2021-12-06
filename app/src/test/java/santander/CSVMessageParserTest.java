package santander;

import org.junit.jupiter.api.Test;
import santander.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVMessageParserTest {

    CSVMessageParser messageParser = new CSVMessageParser();

    @Test
    void shouldParseASingleLineIntoAPrice() {
        String message = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001";

        List<Price> result = messageParser.parse(message);

        Price expectedPrice = new Price(
                "106",
                "EUR/USD",
                new BigDecimal("1.1000"),
                new BigDecimal("1.2000"),
                LocalDateTime.of(2020, 6, 1, 12, 1, 1, 1000000)
        );

        assertEquals(List.of(expectedPrice), result);
    }

    @Test
    void shouldParseMultipleLinesIntoPrices() {
        String message = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002";

        List<Price> result = messageParser.parse(message);

        Price expectedPrice1 = new Price(
                "106",
                "EUR/USD",
                new BigDecimal("1.1000"),
                new BigDecimal("1.2000"),
                LocalDateTime.of(2020, 6, 1, 12, 1, 1, 1000000)
        );

        Price expectedPrice2 = new Price(
                "107",
                "EUR/JPY",
                new BigDecimal("119.60"),
                new BigDecimal("119.90"),
                LocalDateTime.of(2020, 6, 1, 12, 1, 2, 2000000)
        );

        assertEquals(List.of(expectedPrice1, expectedPrice2), result);
    }

}