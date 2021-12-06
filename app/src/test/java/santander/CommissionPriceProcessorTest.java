package santander;

import org.junit.jupiter.api.Test;
import santander.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CommissionPriceProcessorTest {

    CommissionPriceProcessor priceProcessor = new CommissionPriceProcessor(new BigDecimal("0.001"));

    @Test
    void shouldAddCommissionToBidAndAskOnPrice() {

        LocalDateTime timestamp = LocalDateTime.now();
        Price adjustedPrice = priceProcessor.process(new Price(
                "id",
                "EUR/USD",
                new BigDecimal("100"),
                new BigDecimal("100"),
                timestamp)
        );

        Price expectedPrice = new Price(
                "id",
                "EUR/USD",
                new BigDecimal("99.900"),
                new BigDecimal("100.100"),
                timestamp);

        assertEquals(expectedPrice, adjustedPrice);

    }

}