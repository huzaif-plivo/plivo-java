package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class PowerpackShortcodeLister extends Lister<ShortcodeResponse> {

 
  private String limit;
  private String offset;
  private String uuid;

  PowerpackShortcodeLister(String uuid) {
    if (!Utils.allNotNull(uuid)) {
      throw new IllegalArgumentException("uuid cannot be null");
    }
    this.uuid = uuid;
  }

  
  public PowerpackShortcodeLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public PowerpackShortcodeLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<ListResponse<ShortcodeResponse>> obtainCall() {
    Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
    String numberpoolpath = powerpack.getNumberpool();
    String[] numberpool_uuid = numberpoolpath.split("/");
    return client().getApiService().powerpackShortcodeList(client().getAuthId(), numberpool_uuid[5], toMap());
  }
}
