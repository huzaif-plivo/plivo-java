package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class ShortcodeResponse extends BaseResponse {

  private String number_pool_uuid;
  private String shortcode;
  private String country_iso2;
  private String added_on;
  
  public String getNumberpoolUUID(){
    return number_pool_uuid;
  }
  public String getShortcode(){
    return shortcode;
  }
  
  public String getCountry_iso2(){
    return country_iso2;
    }
 
  public String getAddedOn(){

    return added_on;
  }
}