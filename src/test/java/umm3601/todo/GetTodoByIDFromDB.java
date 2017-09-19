package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.entries.Database getTodo functionality
 */
public class GetTodoByIDFromDB{

  @Test
  public void getBarryTodos() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("588959856f0b82ee93cd93eb");
    assertEquals("Incorrect ID", "588959856f0b82ee93cd93eb", todo._id);
    assertEquals("Incorrect body",
      "Nisi sit non non sunt veniam pariatur. Elit reprehenderit aliqua consectetur est dolor officia et adipisicing elit officia nisi elit enim nisi.", todo.body);
  }

  @Test
  public void getFryTodos() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985c42605d9a2814c7d");
    assertEquals("Incorrect ID", "58895985c42605d9a2814c7d", todo._id);
    assertEquals("Incorrect body",
      "Officia labore pariatur ea commodo deserunt dolore. Adipisicing culpa ullamco nulla ullamco enim consequat ipsum excepteur.", todo.body);
  }
}
