
package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackFindNumber extends Getter<NumberpoolResponse> {
  private String number;
  private String uuid;
  public PowerpackFindNumber(String uuid, String number) {
    super(uuid)
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    if (number == null){
      throw new IllegalArgumentException("number cannot be null");
    }
    this.number = number;
    this.uuid = uuid;
  }

@Override
protected Call<NumberpoolResponse> obtainCall() {
  Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
  String numberpoolpath = powerpack.getNumberpool();
  String[] numberpool_uuid = numberpoolpath.split("/");
  return client().getApiService().powerpackFindNumberGet(client().getAuthId(),numberpool_uuid[5], number);
}
}