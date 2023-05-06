package com.narasimha.taskmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narasimha.taskmanagementsystem.payload.TaskDto;
import com.narasimha.taskmanagementsystem.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//save Task 
	@PostMapping("/{userId}/tasks")
	public ResponseEntity<TaskDto> saveTask(@PathVariable("userId") long userId, @RequestBody TaskDto taskDto){
		return new ResponseEntity<TaskDto>(taskService.saveTask(userId, taskDto), HttpStatus.CREATED);
	}
	//get all Task 
	@GetMapping("/{userId}/tasks")
	public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable("userId") long userId){
		return new ResponseEntity<List<TaskDto>>(taskService.getAllTasks(userId), HttpStatus.OK);
	}
	//get individual task 
	@GetMapping("/{userId}/task/{taskId}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId){
		return new ResponseEntity<TaskDto>(taskService.getTaskById(userId,taskId), HttpStatus.OK);
	}
	//delete individual task
	@DeleteMapping("/{userId}/task/{taskId}")
	public ResponseEntity<String> deleteTaskById(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId){
		taskService.deleteTaskById(userId, taskId);
		return new ResponseEntity<String>("task with id "+taskId+" is deleted successfully", HttpStatus.OK);
	}
}
