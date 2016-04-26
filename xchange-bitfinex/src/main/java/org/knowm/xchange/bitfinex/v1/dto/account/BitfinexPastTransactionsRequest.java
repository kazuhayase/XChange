package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BitfinexPastTransactionsRequest {

    @JsonProperty("request")
    protected String request;

    @JsonProperty("nonce")
    protected String nonce;

    @JsonProperty("currency")
    protected String currency;

    @JsonProperty("method")
    protected String method;

    @JsonProperty("since")
    protected Date since;

    @JsonProperty("until")
    protected Date until;

    @JsonProperty("limit")
    protected int limit;

    /**
     * Constructor
     *
     * @param nonce
     * @param currency
     * @param method
     * @param since
     * @param until
     * @param limit
     */
    public BitfinexPastTransactionsRequest(String nonce, String currency, String method, Long since, Long until, int limit) {

        this.request = "/v1/history/movements";
        this.nonce = nonce;
        this.currency = currency;
        this.method = method;
        this.since = since == null ? null : new Date(since);
        this.until = until == null ? null : new Date(until);
        this.limit = limit;
    }
}
