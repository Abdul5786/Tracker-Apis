package com.assigment.tracker.services.servicesImpl;

import com.assigment.tracker.config.ModelMapperConfig;
import com.assigment.tracker.entities.Tasks;
import com.assigment.tracker.exception.ResourceNotFoundException;
import com.assigment.tracker.payloads.TasksDto;
import com.assigment.tracker.repositories.TaskRepo;
import com.assigment.tracker.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskServices
{

    @Autowired
    ModelMapperConfig modelMapperConfig;

    @Autowired
    TaskRepo taskRepo;

    // adding task
    @Override
    public TasksDto createTasks(TasksDto tasksDto)
    {
        Tasks tasks = this.tasksDtOToTask(tasksDto);
        tasks.setDate(tasksDto.getDate());
        Tasks saved = taskRepo.save(tasks);

        return   this.tasksToTaskDto(saved);
    }

    // getting task by Id
    @Override
    public TasksDto getTaskById(String taskId)
    {

        Tasks tasks = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found with resource ", "id", taskId));
         return this.tasksToTaskDto(tasks);
    }

    // getting all tasks by Id  then using stream apis to convert them into dtos
    @Override
    public List<TasksDto> getAllTask()
    {
        List<Tasks> allTrackRecords = taskRepo.findAll();
        List<TasksDto> allDtoTrackRecords = allTrackRecords.stream().map(t -> this.tasksToTaskDto(t)).collect(Collectors.toList());
        return allDtoTrackRecords;
    }

    // updating task by Id
    @Override
    public TasksDto updateTask(TasksDto tasksDto,String taskId)
    {
        Tasks tasks = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found with resource ", "id", taskId));
        tasks.setDescription(tasksDto.getDescription());

        tasks.setTitle(tasksDto.getTitle());
        return this.tasksToTaskDto(tasks);

    }

    @Override
    public void deleteTasks(String taskId)
    {
         taskRepo.deleteById(taskId);
    }


    public Tasks tasksDtOToTask (TasksDto tasksDto)
    {
        return  this.modelMapperConfig.modelMapper().map(tasksDto,Tasks.class);
    }

    public TasksDto tasksToTaskDto(Tasks tasks)
    {
        return this.modelMapperConfig.modelMapper().map(tasks,TasksDto.class);
    }
}
