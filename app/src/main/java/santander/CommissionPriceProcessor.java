package santander;

import santander.model.Price;

import java.math.BigDecimal;

public class CommissionPriceProcessor implements PriceProcessor {

    private final BigDecimal commission;

    public CommissionPriceProcessor(BigDecimal commission) {
        this.commission = commission;
    }

    public Price process(Price originalPrice) {
        BigDecimal originalBidPrice = originalPrice.getBidPrice();
        BigDecimal newBid = originalBidPrice.subtract(commissionValue(originalBidPrice));

        BigDecimal originalAskPrice = originalPrice.getBidPrice();
        BigDecimal newAsk = originalAskPrice.add(commissionValue(originalAskPrice));
        return new Price(
                originalPrice.getId(),
                originalPrice.getInstrumentName(),
                newBid,
                newAsk,
                originalPrice.getTimestamp()
        );
    }

    private BigDecimal commissionValue(BigDecimal originalPrice) {
        return originalPrice.multiply(commission);
    }
}
