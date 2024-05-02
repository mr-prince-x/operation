package com.qs.task.poc.repository;

import com.qs.task.poc.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<RegisterUser,Integer> {

  RegisterUser findByQsuserUseremail(String useremail);
  RegisterUser findByname(String username);
}
