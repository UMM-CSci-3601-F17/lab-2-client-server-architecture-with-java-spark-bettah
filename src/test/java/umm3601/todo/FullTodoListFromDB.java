package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Tests umm3601.user.Database listUser functionality
 */
public class FullTodoListFromDB {

  @Test
  public void totalTodosCount() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTodos.length);
  }

  @Test
  public void firstTodoInFullList() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo firstTodo = allTodos[0];
    assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
    assertEquals("Incorrect status", false, firstTodo.status);
    assertEquals("Incorrect body",
      "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", firstTodo.body);
    assertEquals("Incorrect category","software design", firstTodo.category);
  }
}
