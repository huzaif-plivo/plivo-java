package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackGetter extends Getter<Powerpack> {

  public PowerpackGetter(String uuid) {
    super(uuid);
  }

  @Override
  protected Call<Powerpack> obtainCall() {
    return client().getApiService().powerpackGet(client().getAuthId(), uuid);
  }
}
