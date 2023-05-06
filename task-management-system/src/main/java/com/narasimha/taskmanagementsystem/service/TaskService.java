package com.narasimha.taskmanagementsystem.service;

import java.util.List;

import com.narasimha.taskmanagementsystem.payload.TaskDto;

public interface TaskService {

	public TaskDto saveTask(Long userId, TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(Long userId);
	
	public TaskDto getTaskById(Long userId,Long taskId);
	
	public void deleteTaskById(Long userId,Long taskId);
}
