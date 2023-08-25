package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
     tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
     tasks.get(description).setComplete(true);
   }

   public boolean getStatus(String description) {
      return tasks.get(description).isComplete();
   }

   public Task getTask(String description) {
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
     return tasks.values().stream().filter(Task::isComplete).collect(Collectors.toList());
   }
}
