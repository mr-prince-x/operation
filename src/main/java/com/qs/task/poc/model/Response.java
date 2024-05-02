package com.qs.task.poc.model;

public class Response {

  public Response(int status, String message) {
      this.message = message;
      this.status = status;
  }
  private int status;
  private String message;

}
