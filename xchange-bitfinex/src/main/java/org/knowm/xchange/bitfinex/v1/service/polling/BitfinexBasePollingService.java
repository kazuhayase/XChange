package org.knowm.xchange.bitfinex.v1.service.polling;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.bitfinex.v1.BitfinexAdapters;
import org.knowm.xchange.bitfinex.v1.BitfinexAuthenticated;
import org.knowm.xchange.bitfinex.v1.service.BitfinexHmacPostBodyDigest;
import org.knowm.xchange.bitfinex.v1.service.BitfinexPayloadDigest;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.polling.BasePollingService;
import si.mazi.rescu.ClientConfig;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BitfinexBasePollingService extends BaseExchangeService implements BasePollingService {

  protected final String apiKey;
  protected final BitfinexAuthenticated bitfinex;
  protected final ParamsDigest signatureCreator;
  protected final ParamsDigest payloadCreator;

  public final static String HTTP_READ_TIMEOUT = "HTTP_READ_TIMEOUT";
  public final static String HTTP_CONN_TIMEOUT = "HTTP_CONN_TIMEOUT";

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitfinexBasePollingService(Exchange exchange) {

    super(exchange);
    ClientConfig config = new ClientConfig();
    Object readTimeout = exchange.getExchangeSpecification().getParameter(HTTP_READ_TIMEOUT);
    if (readTimeout != null) {
      try {
        int timeoutValue = Integer.parseInt(readTimeout.toString());
        config.setHttpReadTimeout(timeoutValue);
      } catch (NumberFormatException e) {
      }
    }
    Object connectTimeout = exchange.getExchangeSpecification().getParameter(HTTP_CONN_TIMEOUT);
    if (connectTimeout != null) {
      try {
        int timeoutValue = Integer.parseInt(connectTimeout.toString());
        config.setHttpConnTimeout(timeoutValue);
      } catch (NumberFormatException e) {
      }
    }
    this.bitfinex = RestProxyFactory.createProxy(BitfinexAuthenticated.class, exchange.getExchangeSpecification().getSslUri(), config);
    this.apiKey = exchange.getExchangeSpecification().getApiKey();
    this.signatureCreator = BitfinexHmacPostBodyDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    this.payloadCreator = new BitfinexPayloadDigest();
  }

  @Override
  public List<CurrencyPair> getExchangeSymbols() throws IOException {

    List<CurrencyPair> currencyPairs = new ArrayList<CurrencyPair>();
    for (String symbol : bitfinex.getSymbols()) {
      currencyPairs.add(BitfinexAdapters.adaptCurrencyPair(symbol));
    }
    return currencyPairs;
  }
}
