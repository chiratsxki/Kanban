package com.chiratsxki.kanban;

import com.chiratsxki.kanban.model.Task;
import com.chiratsxki.kanban.service.TaskService;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KanbanApplication implements CommandLineRunner {

	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(KanbanApplication.class, args);
	}

	@Override
	public void run(String ... args) {
		Task newTask = new Task();
		newTask.setTitle("New task");
		newTask.setDescription("This is my description");
		newTask.setStatus("Process");

		taskService.createTask(newTask);
	}
}
