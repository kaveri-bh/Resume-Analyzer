package com.resumeanalyzer.model;
import jakarta.persistence.*;
@Entity public class LearningEntry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String owner; private String topic; private java.time.LocalDate entryDate; private Double hours; @Column(length=5000) private String details;
 public Long getId(){return id;}
 public String getOwner(){return owner;} public void setOwner(String v){owner=v;}
 public String getTopic(){return topic;} public void setTopic(String v){topic=v;}
 public java.time.LocalDate getEntryDate(){return entryDate;} public void setEntryDate(java.time.LocalDate v){entryDate=v;}
 public Double getHours(){return hours;} public void setHours(Double v){hours=v;}
 public String getDetails(){return details;} public void setDetails(String v){details=v;}
}
