package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Powerpack extends BaseResource {

  private String createdOn;
  private String name;
  private String application_type;
  private String application_id;
  private Boolean sticky_sender;
  private Boolean local_connect;
  private String number_pool;

  public String getCreatedOn() {
    return createdOn;
  }

  public String getName(){
    return name;
  }
  public String getApplicationType(){
    return application_type;
  }
  public String getApplicationID(){
    return application_id;
  }
  public Boolean getStickySender(){
    return sticky_sender;
  }
  public Boolean getLocalConnect(){
    return local_connect;
  }
  public String getNumberpool(){
    return number_pool;
  }

  public static PowerpackDeleter deleter(String uuid) {
    return new PowerpackDeleter(uuid);
  }

  public static PowerpackCreator create(String name){
    return new PowerpackCreator(name);
  }
  
  public static PowerpackUpdater updater(String uuid) {
    return new PowerpackUpdater(uuid);
  }

  public static PowerpackGetter getter(String uuid) {
    return new PowerpackGetter(uuid);
  }
  
  public static PowerpackLister lister() {
    return new PowerpackLister();
  }

  public static PowerpackNumberLister numberlister(String uuid){
    return new PowerpackNumberLister(uuid);
  }

  public static PowerpackNumberCount countnumber(String uuid){
    return new PowerpackNumberCount(uuid);
  }

  public static PowerpackAddNumber addnumber(String uuid, String number){
    return new PowerpackAddNumber(uuid, number);
  }

  public static PowerpackRemoveNumber removenumber(String uuid, String number){
    return new PowerpackRemoveNumber(uuid, number);
  }

  public static PowerpackFindNumber findnumber(String uuid, String number){
    return new PowerpackFindNumber(uuid, number);
  }
 
  public static PowerpackShortcodeLister shortcodelister(String uuid){
    return new PowerpackShortcideLister(uuid);
  }
  
  public static PowerpackFindShortcode findshortcode(String uuid, String shortcode){
    return new PowerpackFindShortcode(uuid, shortcode);
  }

  public static PowerpackBuyAndAddNumber buyandaddnumber(string uuid){
    return new PowerpackBuyAndAddNumber(uuid);
  }


}
