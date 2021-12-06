package santander;

import santander.model.Price;

public interface PriceProcessor {
    public Price process(Price originalPrice);
}
