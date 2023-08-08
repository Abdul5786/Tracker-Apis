package com.assigment.tracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Tasks")
@NoArgsConstructor
@Getter
@Setter
public class Tasks
{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private String id;
     @Column(name = "title",nullable = false,length = 200)
     private String title;
     @Column(name = "description",nullable = false,length = 2000)
     private String description;
     @Column(name = "Date")
     private Date date;


}
