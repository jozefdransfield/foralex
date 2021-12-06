package santander;

import santander.model.Price;

import java.util.List;

public class MessageReceiver {

    private final MessageParser messageParser;
    private final PriceProcessor priceProcessor;
    private final PricePublisher pricePublisher;

    public MessageReceiver(MessageParser messageParser, PriceProcessor priceProcessor, PricePublisher pricePublisher) {
        this.messageParser = messageParser;
        this.priceProcessor = priceProcessor;
        this.pricePublisher = pricePublisher;
    }

    public void onReceive(String message) {
        List<Price> prices = messageParser.parse(message);

        prices.stream()
                .map(priceProcessor::process)
                .forEach(pricePublisher::publish);
    }
}
