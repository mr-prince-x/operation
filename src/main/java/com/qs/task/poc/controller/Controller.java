package com.qs.task.poc.controller;

import com.qs.task.poc.UserNotfound;
import com.qs.task.poc.model.QSUser;
import com.qs.task.poc.model.RegisterUser;
import com.qs.task.poc.model.Response;
import com.qs.task.poc.service.ServiceImpl;
import com.qs.task.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {

	@Autowired
  UserService userservice;

  private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

  public static boolean isValidEmail(String email) {
    Pattern pattern = Pattern.compile(EMAIL_REGEX);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

//  public static boolean isValidPassword(String password) {
//     int minLength=6, maxLength=12;
//    // Check if the password length is within the specified range
//    return password.length() >= minLength && password.length() <= maxLength;
//  }

  @GetMapping("/welcome")
  public String welcome(){
    return "welcome to user helping application";
  }
    @PostMapping("/login")
    private ResponseEntity<?> loginUser(@RequestBody RegisterUser userData) throws UserNotfound{
      RegisterUser user=userservice.getUser(userData.getQsuser().getUseremail());
      if(isValidEmail(userData.getQsuser().getUseremail())==false){
        return new ResponseEntity<>("enter valid userId",HttpStatus.BAD_REQUEST);

      }else if(!(user.getQsuser().getUseremail().equals(userData.getQsuser().getUseremail()))){
        //  throw new UserNotfound("no user found");
        return new ResponseEntity<>("no user",HttpStatus.NO_CONTENT);

      }
      if (user.getQsuser().getUseremail().equals(userData.getQsuser().getUseremail()) && user.getQsuser().getPassword().equals(userData.getQsuser().getPassword())) {
        return new ResponseEntity<RegisterUser>(user, HttpStatus.OK);
      }
      return new ResponseEntity<>("bad Request ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

  @PostMapping("/add")
  public ResponseEntity<?> addUser(@RequestBody RegisterUser user) {

    if (user == null) {
      return new ResponseEntity<>("invalid user type", HttpStatus.OK);
    } else if (user.getName() == (null) || user.getQsuser().getPassword() == null) {
      return new ResponseEntity<>("invalid user attribute", HttpStatus.OK);
    } else {
      userservice.saveuser(user);
      Response res = new Response(201, "created");
      return new ResponseEntity<Response>( res, HttpStatus.CREATED);
    }
  }
}


