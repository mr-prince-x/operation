package com.qs.task.poc.service;

import com.qs.task.poc.model.QSUser;
import com.qs.task.poc.model.RegisterUser;
import com.qs.task.poc.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserService {



//	@Autowired
//  Repo repo;
  @Autowired
    RegisterRepo reporegister;
@Override
  public RegisterUser getUser(String username) {
    RegisterUser user= reporegister.findByname(username);
    return user;
  }

  @Override
  public RegisterUser getUserbyEmail(String useremail) {
  RegisterUser user = reporegister.findByQsuserUseremail(useremail);
  return user;
  }

  @Override
  public RegisterUser saveuser(RegisterUser user) {
    return reporegister.save(user);
  }

}



