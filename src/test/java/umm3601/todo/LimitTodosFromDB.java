package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.User;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class LimitTodosFromDB {

  @Test
  public void LimitTodos() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] limit7AllTodos = db.limitTodos(allTodos, 7);
    assertEquals("More todos returned than limit should allow", 7, limit7AllTodos.length);

    Todo[] limit157AllTodos = db.limitTodos(allTodos, 157);
    assertEquals("More todos returned than limit should allow", 157, limit157AllTodos.length);

    Todo[] limit0AllTodos = db.limitTodos(allTodos, 0);
    assertEquals("More todos returned than limit should allow", 0, limit0AllTodos.length);

    Todo[] limit300AllTodos = db.limitTodos(allTodos, 300);
    assertEquals("More todos returned than limit should allow", 300, limit300AllTodos.length);

    Todo[] limit305AllTodos = db.limitTodos(allTodos, 305);
    assertEquals("More todos returned than limit should allow", 300, limit305AllTodos.length);

    Todo[] negativeLimitAllTodos = db.limitTodos(allTodos, -5);
    assertEquals("More todos returned than limit should allow", 0, negativeLimitAllTodos.length);
  }

  @Test
  public void listTodosWithLimit() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("limit", new String[]{"7"});
    Todo[] limit7Todos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 7, limit7Todos.length);

    queryParams.put("limit", new String[]{"157"});
    Todo[] limit157Todos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 157, limit157Todos.length);

    queryParams.put("limit", new String[]{"0"});
    Todo[] limit0Todos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 0, limit0Todos.length);

    queryParams.put("limit", new String[]{"300"});
    Todo[] limit300Todos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 300, limit300Todos.length);

    queryParams.put("limit", new String[]{"305"});
    Todo[] limit305Todos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 300, limit305Todos.length);

    queryParams.put("limit", new String[]{"-5"});
    Todo[] negativeLimitTodos = db.listTodos(queryParams);
    assertEquals("More todos returned than limit should allow", 0, negativeLimitTodos.length);
  }
}
