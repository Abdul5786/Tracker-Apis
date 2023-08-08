package com.assigment.tracker.services;


import com.assigment.tracker.payloads.TasksDto;

import java.util.List;

public interface TaskServices
{
    //   for creating tasks
    TasksDto createTasks(TasksDto tasksDto);

    // for getTING  tasks by Id
    TasksDto getTaskById(String taskId);
    // TO get all the tasks in the databases
    List<TasksDto> getAllTask();
    //to update Tasks by fetching using Id
    TasksDto updateTask(TasksDto tasksDto,String taskId);
    // to delete tasks
   void deleteTasks(String  taskId);

}
