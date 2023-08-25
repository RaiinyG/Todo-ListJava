package sg.edu.nus.iss.epat.tdd.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ToDoListTest extends TestCase {
   // Define Test Fixturest
  public ToDoList toDoList;
  public Task testlaksa = new Task("Eat Laksa");
  public Task testchips = new Task("Eat Chips");
  public Task testhotpot = new Task("Eat Hotpot");
  public Task testteh = new Task("Drink Teh", true);

   public ToDoListTest() {
      super();
   }

   @Override
   @Before
   public void setUp() throws Exception {
      // Initialise Test Fixtures
     toDoList = new ToDoList();
     toDoList.addTask(testlaksa);
     toDoList.addTask(testchips);
     toDoList.addTask(testhotpot);
     toDoList.addTask(testteh);
   }

   @Override
   @After
   public void tearDown() throws Exception {
      // Uninitialise test Fixtures
   }

   @Test
   public void testAddTask() {
     List<Task> result = new ArrayList<Task>(toDoList.getAllTasks());
     List<String> descriptions = result.stream().map(Task::getDescription).collect(Collectors.toList());
     assertTrue(descriptions.contains("Eat Laksa"));
     assertTrue(descriptions.contains("Eat Chips"));
     assertTrue(descriptions.contains("Eat Hotpot"));
     assertTrue(descriptions.contains("Drink Teh"));
   }

   @Test
   public void testGetStatus() {
     Assert.assertFalse(toDoList.getStatus("Eat Laksa"));
     Assert.assertFalse(toDoList.getStatus("Eat Chips"));
     Assert.assertFalse(toDoList.getStatus("Eat Hotpot"));
     Assert.assertTrue(toDoList.getStatus("Drink Teh"));
   }

   @Test
   public void testRemoveTask() {
     List<Task> result = new ArrayList<Task>(toDoList.getAllTasks());
     Assert.assertEquals(4, result.size());
     toDoList.removeTask("Eat Laksa");
     result = new ArrayList<Task>(toDoList.getAllTasks());
     Assert.assertEquals(3, result.size());
   }

   @Test
   public void testGetCompletedTasks() {
    List<Task> result = new ArrayList<Task>(toDoList.getCompletedTasks());
     assertEquals("Drink Teh", result.get(0).getDescription());
   }

  @Test
  public void testGetTask() {
    Task res = toDoList.getTask("Eat Laksa");
    assertEquals(res.getDescription(), "Eat Laksa");
  }


   @Test
  public void testCompleteTask() {
     Task res = toDoList.getTask("Eat Laksa");
     assertEquals(res.isComplete(), false);
     toDoList.completeTask("Eat Laksa");
     res = toDoList.getTask("Eat Laksa");
     assertEquals(res.isComplete(), true);
   }
}
