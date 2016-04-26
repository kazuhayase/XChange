package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BitfinexPastTransactionsResponse {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("method")
    private String method;
    @JsonProperty("type")
    private String type;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private String status;
    @JsonProperty("timestamp")
    private BigDecimal timestamp;


    public BitfinexPastTransactionsResponse(@JsonProperty("currency") String currency, @JsonProperty("method") String method,
                                            @JsonProperty("type") String type, @JsonProperty("amount") BigDecimal amount,
                                            @JsonProperty("description") String description, @JsonProperty("status") String status,
                                            @JsonProperty("timestamp") BigDecimal timestamp) {

        this.currency = currency;
        this.method = method;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMethod() {
        return method;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("BitfinexPastTransactionsResponse [currency=");
        builder.append(currency);
        builder.append(", method=");
        builder.append(method);
        builder.append(", type=");
        builder.append(type);
        builder.append(", amount=");
        builder.append(amount);
        builder.append(", description=");
        builder.append(description);
        builder.append(", status=");
        builder.append(status);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }
}
