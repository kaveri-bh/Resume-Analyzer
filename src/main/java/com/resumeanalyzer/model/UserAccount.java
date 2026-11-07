package com.resumeanalyzer.model;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class UserAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false) private String fullName;
 public Long getId(){return id;} public String getEmail(){return email;} public void setEmail(String x){email=x;}
 public String getPassword(){return password;} public void setPassword(String x){password=x;}
 public String getFullName(){return fullName;} public void setFullName(String x){fullName=x;}
}
