package org.knowm.xchange.bitfinex.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BitfinexSymbolInfo {
    private final String pair;
    private final Integer pricePrecision;
    private final BigDecimal initialMargin;
    private final BigDecimal minimumMargin;
    private final BigDecimal maximumOrderSize;
    private final BigDecimal minimumOrderSize;
    private final String expiration;

    private final BigDecimal minPrice;

    /**
     * @param pair
     * @param pricePrecision
     * @param initialMargin
     * @param minimumMargin
     * @param maximumOrderSize
     * @param minimumOrderSize
     * @param expiration
     */
    public BitfinexSymbolInfo(@JsonProperty("pair") String pair, @JsonProperty("price_precision") Integer pricePrecision, @JsonProperty("initial_margin") BigDecimal initialMargin,
                              @JsonProperty("minimum_margin") BigDecimal minimumMargin, @JsonProperty("maximum_order_size") BigDecimal maximumOrderSize,
                              @JsonProperty("minimum_order_size") BigDecimal minimumOrderSize, @JsonProperty("expiration") String expiration) {
        this.pair = pair;
        this.pricePrecision = pricePrecision;
        this.initialMargin = initialMargin;
        this.minimumMargin = minimumMargin;
        this.maximumOrderSize = maximumOrderSize;
        this.minimumOrderSize = minimumOrderSize;
        this.expiration = expiration;

        this.minPrice = new BigDecimal(1 / Math.pow(10, pricePrecision)).setScale(pricePrecision, RoundingMode.DOWN);
    }

    public String getPair() {
        return pair;
    }

    public Integer getPricePrecision() {
        return pricePrecision;
    }

    public BigDecimal getInitialMargin() {
        return initialMargin;
    }

    public BigDecimal getMinimumMargin() {
        return minimumMargin;
    }

    public BigDecimal getMaximumOrderSize() {
        return maximumOrderSize;
    }

    public BigDecimal getMinimumOrderSize() {
        return minimumOrderSize;
    }

    public String getExpiration() {
        return expiration;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    @Override
    public String toString() {
        return "BitfinexSymbolInfo [pair=" + pair + ", pricePrecision=" + pricePrecision + ", initialMargin=" + initialMargin + ", minimumMargin=" + minimumMargin +
                ", maximumOrderSize=" + maximumOrderSize + ", minimumOrderSize=" + minimumOrderSize + ", expiration=" + expiration + "]";
    }
}
