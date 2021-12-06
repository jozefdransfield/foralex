package santander;

import santander.model.Price;

import java.util.List;

public interface MessageParser {
    public List<Price> parse(String message);
}
