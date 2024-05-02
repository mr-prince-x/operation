package com.qs.task.poc.service;

import com.qs.task.poc.model.QSUser;
import com.qs.task.poc.model.RegisterUser;

public interface UserService {

  RegisterUser getUser(String userId);

  RegisterUser getUserbyEmail(String useremail);

  RegisterUser saveuser(RegisterUser user);

}
