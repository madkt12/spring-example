package sda.remote28.springexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sda.remote28.springexample.task_manager.model.Board;
import sda.remote28.springexample.task_manager.model.PriorityStatus;
import sda.remote28.springexample.task_manager.model.Task;
import sda.remote28.springexample.task_manager.model.TaskStatus;
import sda.remote28.springexample.task_manager.repository.BoardRepository;
import sda.remote28.springexample.task_manager.repository.TaskRepository;

@Component
public class CommandLineRunnerUsingServiceClass implements CommandLineRunner {

    @Value("${ee.sda.example.message}")
    private String message;

    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;

    public CommandLineRunnerUsingServiceClass(TaskRepository taskRepository, BoardRepository boardRepository) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Board board1 = new Board();
        board1.setDescription("Test Board 1");
        board1.setTeamName("team 1");
        board1.setProjectName("Project 1");
        boardRepository.save(board1);

        Board board2 = new Board();
        board2.setDescription("Test Board 2");
        board2.setTeamName("team 2");
        board2.setProjectName("Project 2");
        boardRepository.save(board2);

        Task task1 = new Task();
        task1.setBoardId(1l);
        task1.setStatus(TaskStatus.TODO);
        task1.setDescription("Description for Task 1");
        task1.setTitle("Task 1");
        task1.setPriority(PriorityStatus.HIGH);
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setBoardId(1l);
        task2.setStatus(TaskStatus.IN_PROGRESS);
        task2.setDescription("Description for Task 2");
        task2.setTitle("Task 2");
        task2.setPriority(PriorityStatus.URGENT);
        taskRepository.save(task2);

        Task task3 = new Task();
        task3.setBoardId(2l);
        task3.setStatus(TaskStatus.IN_REVIEW);
        task3.setDescription("Description for Task 3");
        task3.setTitle("Task 3");
        task3.setPriority(PriorityStatus.LOW);
        taskRepository.save(task3);
    }
}
