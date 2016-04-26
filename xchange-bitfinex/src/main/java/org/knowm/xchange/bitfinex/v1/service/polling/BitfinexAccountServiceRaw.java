package org.knowm.xchange.bitfinex.v1.service.polling;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.bitfinex.v1.dto.BitfinexException;
import org.knowm.xchange.bitfinex.v1.dto.account.*;
import org.knowm.xchange.exceptions.ExchangeException;

import java.io.IOException;
import java.math.BigDecimal;

public class BitfinexAccountServiceRaw extends BitfinexBasePollingService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitfinexAccountServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public BitfinexBalancesResponse[] getBitfinexAccountInfo() throws IOException {

    try {
      BitfinexBalancesResponse[] balances = bitfinex.balances(apiKey, payloadCreator, signatureCreator,
          new BitfinexBalancesRequest(String.valueOf(exchange.getNonceFactory().createValue())));
      return balances;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }

  public BitfinexMarginInfosResponse[] getBitfinexMarginInfos() throws IOException {

    try {
      BitfinexMarginInfosResponse[] marginInfos = bitfinex.marginInfos(apiKey, payloadCreator, signatureCreator,
          new BitfinexMarginInfosRequest(String.valueOf(exchange.getNonceFactory().createValue())));
      return marginInfos;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }

  public String withdraw(String withdrawType, String walletSelected, BigDecimal amount, String address) throws IOException {

    BitfinexWithdrawalResponse[] withdrawRepsonse = bitfinex.withdraw(apiKey, payloadCreator, signatureCreator,
        new BitfinexWithdrawalRequest(String.valueOf(exchange.getNonceFactory().createValue()), withdrawType, walletSelected, amount, address));
    return withdrawRepsonse[0].getWithdrawalId();
  }

  public BitfinexPastTransactionsResponse[] getBitfinexTransactionHistory(String currency, String method, Long since, Long until, int limit) throws IOException {

    try {
      BitfinexPastTransactionsResponse[] trades = bitfinex.pastTransactions(apiKey, payloadCreator, signatureCreator,
              new BitfinexPastTransactionsRequest(String.valueOf(exchange.getNonceFactory().createValue()), currency, method, since, until, limit));
      return trades;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }
}
