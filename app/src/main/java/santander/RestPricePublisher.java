package santander;

import santander.model.Price;

public class RestPricePublisher implements PricePublisher {

    @Override
    public void publish(Price price) {
        System.out.println("price = " + price);
    }
}
