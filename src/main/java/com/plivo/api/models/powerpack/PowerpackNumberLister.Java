package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class PowerpackNumberLister extends Lister<NumberpoolResponse> {

 
  private String limit;
  private String offset;
  private String pattern;
  private String country_iso;
  private String type;
  private String uuid;

  PowerpackNumberLister(String uuid) {
    if (!Utils.allNotNull(uuid)) {
      throw new IllegalArgumentException("uuid cannot be null");
    }

    this.uuid = uuid;
  }

  public PowerpackNumberLister pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }
  public PowerpackNumberLister country_iso(String country_iso) {
    this.country_iso = country_iso;
    return this;
  }
  public PowerpackNumberLister type(String type) {
    this.type = type;
    return this;
  }
  public PowerpackNumberLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public PowerpackNumberLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<ListResponse<NumberpoolResponse>> obtainCall() {
    Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
    String numberpoolpath = powerpack.getNumberpool();
    String[] numberpool_uuid = numberpoolpath.split("/");
    return client().getApiService().powerpackNumberList(client().getAuthId(), numberpool_uuid[5], toMap());
  }
}
