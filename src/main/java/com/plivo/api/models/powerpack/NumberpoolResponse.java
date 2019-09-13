package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class NumberpoolResponse extends BaseResponse {

  private String number_pool_uuid;
  private String number;
  private String type;
  private String country_iso2;
  private String account_phone_number_resource;
  private String added_on;
  
  public String getNumberpoolUUID(){
    return number_pool_uuid;
  }
  public String getNumber(){
    return number;
  }
  public String getType(){
    return type;
  }
  public String getCountry_iso2(){
    return country_iso2;
    }
  public String getAccountPhoneNumberResource(){
    return account_phone_number_resource;
  }
  public String getAddedOn(){

    return added_on;
  }
}