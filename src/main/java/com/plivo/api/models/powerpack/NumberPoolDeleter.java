package com.plivo.api.models.powerpack;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class PowerpackNumberDeleter extends Deleter<Powerpack> {

  private Boolean unrent;

  public PowerpackNumberDeleter(final String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }
  
  public Boolean unrent(){
    return this.unrent;
  }
  /**
   * @param unrent Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public PowerpackNumberDeleter unren(final Boolean unrent){
    this.unrent = unrent;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackNumberDelete(client().getAuthId(), uuid, this);
  }
}