package com.chiratsxki.kanban;

import static org.junit.jupiter.api.Assertions.*;
import com.chiratsxki.kanban.model.Task;
import com.chiratsxki.kanban.repository.TaskRepository;
import com.chiratsxki.kanban.service.TaskService;
import com.chiratsxki.kanban.service.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {

    private TaskService taskService;

    private TaskRepository taskRepository = mock(TaskRepository.class);

    @BeforeEach
    void setUp() {
        taskService = new TaskServiceImpl(taskRepository);
    }

    @Test
    void getAllTask_ShouldReturnAllTasks() {
        Task task1 = new Task();
        Task task2 = new Task();
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals(task1, result.get(0));
        assertEquals(task2, result.get(1));
    }

    @Test
    void createTask_ShouldCreateTask() {
        Task taskToCreate = new Task();
        when(taskRepository.save(any(Task.class))).thenReturn(taskToCreate);

        Task result = taskService.createTask(taskToCreate);

        assertNotNull(result);
        assertEquals(taskToCreate, result);
        verify(taskRepository, times(1)).save(eq(taskToCreate));
    }
}
