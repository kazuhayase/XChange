package org.knowm.xchange.btce.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.btce.v3.dto.BTCEReturn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raphael Voellmy
 */
public class BTCETradeHistoryReturn extends BTCEReturn<Map<Long, BTCETradeHistoryResult>> {

  /**
   * Constructor
   * 
   * @param success
   * @param value
   * @param error
   */
  public BTCETradeHistoryReturn(@JsonProperty("success") boolean success, @JsonProperty("return") Map<Long, BTCETradeHistoryResult> value,
      @JsonProperty("error") String error) {
    super(success, value, error);

    Map<Long, BTCETradeHistoryResult> result = new HashMap<>();
    if (value != null) {
      for (Map.Entry<Long, BTCETradeHistoryResult> entry : value.entrySet()) {
        BTCETradeHistoryResult res = entry.getValue();
        res.setId(entry.getKey());
        result.put(entry.getKey(), res);
      }
    }
    this.returnValue = result;
  }
}
