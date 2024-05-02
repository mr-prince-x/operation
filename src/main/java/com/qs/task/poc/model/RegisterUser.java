package com.qs.task.poc.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Register_User")
public class RegisterUser {

  @Id@GeneratedValue(strategy = GenerationType. AUTO)
  private long user_Id;

  private String name;
  @OneToOne(cascade = CascadeType.ALL)
  QSUser qsuser;

}
