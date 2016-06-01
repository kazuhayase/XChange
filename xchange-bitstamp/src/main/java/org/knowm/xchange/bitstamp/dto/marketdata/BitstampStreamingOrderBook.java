package org.knowm.xchange.bitstamp.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ryan Sundberg
 */
public class BitstampStreamingOrderBook extends BitstampOrderBook {

  /**
   * Constructor
   *
   * @param bids
   * @param asks
   */
  public BitstampStreamingOrderBook(@JsonProperty("timestamp") Long timestamp, @JsonProperty("bids") List<List<BigDecimal>> bids, @JsonProperty("asks") List<List<BigDecimal>> asks) {
    super(timestamp, bids, asks);
  }

}
