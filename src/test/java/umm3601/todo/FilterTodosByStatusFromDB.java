package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.Database filtertodosByAge
 * and listtodos with _age_ query parameters
 */
public class FilterTodosByStatusFromDB {

  @Test
  public void filterTodosByStatus() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] statusTrueTodos = db.filterTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of todos with status true", 143, statusTrueTodos.length);

    Todo[] statusFalseTodos = db.filterTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of todos with status false", 157, statusFalseTodos.length);
  }

  @Test
  public void listtodosWithAgeFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"true"});
    Todo[] statusTrueTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status true", 143, statusTrueTodos.length);

    queryParams.put("status", new String[] {"false"});
    Todo[] statusFalseTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status false", 157, statusFalseTodos.length);
  }
}
