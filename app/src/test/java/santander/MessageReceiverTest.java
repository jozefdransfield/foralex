package santander;

import org.junit.jupiter.api.Test;
import santander.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

class MessageReceiverTest {

    @Test
    void shouldParseProcessAndPublishAPrice() {
        String message = "message";
        Price price = new Price("id", "instrument-name", BigDecimal.ONE, BigDecimal.ONE, LocalDateTime.now());

        MessageParser messageParser = mock(MessageParser.class);
        PriceProcessor priceProcessor = mock(PriceProcessor.class);
        PricePublisher pricePublisher = mock(PricePublisher.class);

        when(messageParser.parse(message)).thenReturn(List.of(price));
        when(priceProcessor.process(price)).thenReturn(price);

        MessageReceiver messageReceiver = new MessageReceiver(messageParser, priceProcessor, pricePublisher);

        messageReceiver.onReceive(message);

        verify(pricePublisher).publish(price);
    }

}