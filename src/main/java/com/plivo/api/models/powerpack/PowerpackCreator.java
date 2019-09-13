package com.plivo.api.models.powerpack;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;

public class PowerpackCreator extends Creator<PowerpackResponse> {
private String name;
private String application_type;
private String application_id;
private Boolean sticky_sender;
private Boolean local_connect;


PowerpackCreator(String name) {
  if (!Utils.allNotNull(name)) {
    throw new IllegalStateException("powerpack name is required");
  }
  this.name = name;
}

public String name() {
  return this.name;
}

public String application_type() {
  return this.application_type;
}

public String application_id() {
  return this.application_id;
}

public Boolean sticky_sender() {
  return this.sticky_sender;
}

public Boolean local_connect() {
  return this.local_connect;
}


@Override
protected Call<PowerpackCreateResponse> obtainCall() {
  return client().getApiService().createPowerpack(client().getAuthId(), this);
}
}