package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class PowerpackRemoveNumber extends Deleter<Powerpack> {
  private Boolean unrent;
  private String number;
  private String uuid;

  public PowerpackRemoveNumber(final String uuid, final String number) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    if (number == null){
      throw new IllegalArgumentException("number cannot be null");
    }
    this.number = number;
    this.uuid = uuid;
  }
  
  public Boolean unrent(){
    return this.unrent;
  }
  /**
   * @param unrent Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public PowerpackRemoveNumber unrent(final Boolean unrent){
    this.unrent = unrent;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
    String numberpoolpath = powerpack.getNumberpool();
    String[] numberpool_uuid = numberpoolpath.split("/");
    return client().getApiService().powerpackNumberDelete(client().getAuthId(),numberpool_uuid[5], number);
  }
}
