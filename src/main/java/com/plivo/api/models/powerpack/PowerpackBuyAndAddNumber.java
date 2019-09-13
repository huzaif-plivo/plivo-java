
package com.plivo.api.models.powerpack;


import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;


public class PowerpackBuyAndAddNumber extends Creator<NumberpoolResponse> {
  private String number;
  private String uuid;
  private String pattern;
  private String country_iso;
  private String type;
  private String region;

  public PowerpackBuyAndAddNumber(String uuid) {
    super(uuid)
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public PowerpackBuyAndAddNumber getPattern(String pattern) {
    this.pattern = pattern;
    return this;
  }
  public PowerpackBuyAndAddNumber getCountry_iso2(String country_iso2) {
    this.country_iso = country_iso2;
    return this;
  }
  public PowerpackBuyAndAddNumber getType(String type) {
    this.type = type;
    return this;
  }
  public PowerpackBuyAndAddNumber region(String region) {
    this.region = region;
    return this;
  }
  public PowerpackBuyAndAddNumber number(String number) {
    this.number = number;
    return this;
  }
  public String getNumber(){
    return number;
  }

@Override
protected Call<NumberpoolResponse> obtainCall() {
  Powerpack powerpack = client().getApiService().powerpackGet(client().getAuthId(), uuid);
  String numberpoolpath = powerpack.getNumberpool();
  String[] numberpool_uuid = numberpoolpath.split("/");
  if (this.getNumber() !=null){
    return client().getApiService().powerpackAddNumberCreate(client().getAuthId(),numberpool_uuid[5], number);
  } else{
    ListResponse<PhoneNumber> phonenumberlist = client().getApiService().phoneNumberList(client().getAuthId(), toMap());
    if (phonenumberlist.size() < 1){
      throw new ResourceNotFoundException("number not found");
    }
    this.number = phonenumberlist[0].getNumber();
    return client().getApiService().powerpackAddNumberCreate(client().getAuthId(),numberpool_uuid[5], number);
  }
  
}
}