package org.knowm.xchange.btce.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.btce.v3.dto.BTCEReturn;

import java.util.HashMap;
import java.util.Map;

/**
 * Return value from TradeHistory, including overal status and map of transaction ids to TransHistoryResult.
 *
 * @author Peter N. Steinmetz Date: 3/30/15 Time: 3:19 PM
 */
public class BTCETransHistoryReturn extends BTCEReturn<Map<Long, BTCETransHistoryResult>> {

  /**
   * Constructor
   *
   * @param success
   * @param value
   * @param error
   */
  public BTCETransHistoryReturn(@JsonProperty("success") boolean success, @JsonProperty("return") Map<Long, BTCETransHistoryResult> value,
      @JsonProperty("error") String error) {
    super(success, value, error);
    Map<Long, BTCETransHistoryResult> result = new HashMap<>();
    if (value != null) {
      for (Map.Entry<Long, BTCETransHistoryResult> entry : value.entrySet()) {
        BTCETransHistoryResult res = entry.getValue();
        res.setId(entry.getKey());
        result.put(entry.getKey(), res);
      }
    }
    this.returnValue = result;
  }

}
