
package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackFindNumber extends Getter<ShortcodeResponse> {
  private String shortcode;
  private String uuid;
  public PowerpackFindNumber(String uuid, String shortcode) {
    super(uuid)
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    if (shortcode == null){
      throw new IllegalArgumentException("number cannot be null");
    }
    this.number = shortcode;
    this.uuid = uuid;
  }

@Override
protected Call<ShortcodeResponse> obtainCall() {
  Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
  String numberpoolpath = powerpack.getNumberpool();
  String[] numberpool_uuid = numberpoolpath.split("/");
  return client().getApiService().powerpackFindShortcodeGet(client().getAuthId(),numberpool_uuid[5], shortcode);
}
}