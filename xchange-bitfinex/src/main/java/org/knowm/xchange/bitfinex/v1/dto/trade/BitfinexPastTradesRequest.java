package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BitfinexPastTradesRequest {

  @JsonProperty("request")
  protected String request;

  @JsonProperty("nonce")
  protected String nonce;

  @JsonProperty("symbol")
  protected String symbol;

  @JsonProperty("timestamp")
  protected Date timestamp;

  @JsonProperty("limit_trades")
  protected int limitTrades;

  /**
   * Constructor
   * 
   * @param nonce
   * @param symbol
   * @param timestamp
   * @param limitTrades
   */
  public BitfinexPastTradesRequest(String nonce, String symbol, long timestamp, int limitTrades) {

    this.request = "/v1/mytrades";
    this.nonce = nonce;
    this.symbol = symbol;
    this.timestamp = new Date(timestamp);
    this.limitTrades = limitTrades;
  }
}