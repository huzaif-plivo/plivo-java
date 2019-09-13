package com.plivo.api.models.powerpack;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class PowerpackDeleter extends Deleter<Powerpack> {

  private Boolean unrent_numbers;

  public PowerpackDeleter(final String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }
  
  public Boolean unrent_numbers(){
    return this.unrent_numbers;
  }
  /**
   * @param unrent_numbers Specify if the powerpack numbers should be unrent_numbers or not.
   */
  public PowerpackDeleter unrent_numbers(final Boolean unrent_numbers){
    this.unrent_numbers = unrent_numbers;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().powerpackDelete(client().getAuthId(), uuid, this);
  }
}
