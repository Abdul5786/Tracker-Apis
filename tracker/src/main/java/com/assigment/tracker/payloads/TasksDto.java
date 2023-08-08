package com.assigment.tracker.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TasksDto
{

   private String id;
   private String title;
   private String description;
   private Date date;
}
