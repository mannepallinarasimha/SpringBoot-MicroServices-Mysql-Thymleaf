package com.narasimha.taskmanagementsystem.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasimha.taskmanagementsystem.entity.Task;
import com.narasimha.taskmanagementsystem.entity.Users;
import com.narasimha.taskmanagementsystem.exception.ApiException;
import com.narasimha.taskmanagementsystem.exception.TaskNotFoundException;
import com.narasimha.taskmanagementsystem.exception.UsersNotFoundException;
import com.narasimha.taskmanagementsystem.payload.TaskDto;
import com.narasimha.taskmanagementsystem.repository.TaskRepository;
import com.narasimha.taskmanagementsystem.repository.UsersRepository;
import com.narasimha.taskmanagementsystem.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public TaskDto saveTask(Long userId, TaskDto taskDto) {
		// TODO Auto-generated method stub
		//ModelMapper --> user to convert dto to model and model to dto at a time
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new UsersNotFoundException(String.format("UserId %d NOT found", userId)));
		Task task = modelMapper.map(taskDto, Task.class);
		task.setUser(user);
		//after setting the user we are storing the data in DB
		Task savedTask = taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(Long userId) {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new UsersNotFoundException(String.format("UserId %d NOT found", userId)));
		List<Task> tasks = taskRepository.findAllByUserId(userId);
		
		return tasks.stream().map(task -> (modelMapper.map(task, TaskDto.class))).collect(Collectors.toList());
	}

	@Override
	public TaskDto getTaskById(Long userId,Long taskId) {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new UsersNotFoundException(String.format("UserId %d NOT found", userId)));
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(String.format("TaskId %d NOT found", taskId)));
		if(user.getId()!= task.getUser().getId()) {
			throw new ApiException(String.format("task id %d is NOT belongs to userID %d", taskId, userId));
		}
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTaskById(Long userId, Long taskId) {
		Users user = usersRepository.findById(userId)
				.orElseThrow(() -> new UsersNotFoundException(String.format("UserId %d NOT found", userId)));
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(String.format("TaskId %d NOT found", taskId)));
		if(user.getId()!= task.getUser().getId()) {
			throw new ApiException(String.format("task id %d is NOT belongs to userID %d", taskId, userId));
		}
		taskRepository.deleteById(taskId);
	}

}
