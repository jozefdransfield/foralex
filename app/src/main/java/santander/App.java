package santander;

import java.math.BigDecimal;

public class App {

    public static void main(String args[]) {

        MessageReceiver messageReceiver = new MessageReceiver(
                new CSVMessageParser(),
                new CommissionPriceProcessor(new BigDecimal("0.001")),
                new RestPricePublisher());

        messageReceiver.onReceive("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
                "107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
                "108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n" +
                "109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n" +
                "110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110\n");

    }
}
