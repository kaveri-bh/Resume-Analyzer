package com.resumeanalyzer.model;
import jakarta.persistence.*;
@Entity public class Note {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String owner; private String title; private boolean pinned; private java.time.LocalDateTime updatedAt=java.time.LocalDateTime.now(); @Column(length=10000) private String content;
 public Long getId(){return id;}
 public String getOwner(){return owner;} public void setOwner(String v){owner=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getContent(){return content;} public void setContent(String v){content=v;}
 public boolean isPinned(){return pinned;} public void setPinned(boolean v){pinned=v;}
}
