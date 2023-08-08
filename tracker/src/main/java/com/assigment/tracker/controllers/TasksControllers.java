package com.assigment.tracker.controllers;

import com.assigment.tracker.payloads.ApiResponse;
import com.assigment.tracker.payloads.TasksDto;
import com.assigment.tracker.services.TaskServices;
import com.assigment.tracker.services.servicesImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TasksControllers
{
    @Autowired
    TaskServices taskServices;

    // adding new tasks
    @PostMapping(value = "addTasks")
    public ResponseEntity<TasksDto> createTasks(@RequestBody TasksDto tasksDto)
    {
        TasksDto taskdto = taskServices.createTasks(tasksDto);
        return new ResponseEntity<>(taskdto, HttpStatus.CREATED);
    }
 // getting task by Id
    @GetMapping(value = "getTask/{taskId}")
    public ResponseEntity<TasksDto> getTasksById(@PathVariable String taskId)
    {
        TasksDto task = taskServices.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.FOUND);
    }

    //getting all task list
    @GetMapping(value = "getallTasks")
   public ResponseEntity<List<TasksDto>> getAllTasks()
   {
       List<TasksDto> allTask = taskServices.getAllTask();
       return ResponseEntity.ok(allTask);
   }

   //updating the task by getting Id
   @PutMapping(value = "updateTask/{taskId}")
   public ResponseEntity<TasksDto> updateTask(@PathVariable String taskId,@RequestBody TasksDto tasksDto)
   {
       TasksDto updateTasks = taskServices.updateTask(tasksDto, taskId);
       return ResponseEntity.ok(updateTasks);
   }

   // to delete task id by Id
   @DeleteMapping(value = "deleteTask/{taskId}")
   public ResponseEntity<ApiResponse> deleteTaskById(@PathVariable String taskId)
   {
       taskServices.deleteTasks(taskId);
       return new ResponseEntity<ApiResponse>(new ApiResponse("deleted succesfully",true),HttpStatus.OK);
   }



}
