package com.resumeanalyzer.model;
import jakarta.persistence.*;
@Entity public class CalendarEvent {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String owner; private String title; private java.time.LocalDate eventDate; private boolean reminder; @Column(length=2000) private String description;
 public Long getId(){return id;}
 public String getOwner(){return owner;} public void setOwner(String v){owner=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public java.time.LocalDate getEventDate(){return eventDate;} public void setEventDate(java.time.LocalDate v){eventDate=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public boolean isReminder(){return reminder;} public void setReminder(boolean v){reminder=v;}
}
