package santander.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Price {

    private final String id;
    private final String instrumentName;
    private final BigDecimal bidPrice;
    private final BigDecimal askPrice;
    private final LocalDateTime timestamp;

    public Price(String id, String instrumentName, BigDecimal bidPrice, BigDecimal askPrice, LocalDateTime timestamp) {
        this.id = id;
        this.instrumentName = instrumentName;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id.equals(price.id) && instrumentName.equals(price.instrumentName) && bidPrice.equals(price.bidPrice) && askPrice.equals(price.askPrice) && timestamp.equals(price.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrumentName, bidPrice, askPrice, timestamp);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id='" + id + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", bidPrice=" + bidPrice +
                ", askPrice=" + askPrice +
                ", timestamp=" + timestamp +
                '}';
    }
}
