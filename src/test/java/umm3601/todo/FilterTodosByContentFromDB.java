package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Database;
import umm3601.entries.Todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.Database filterTodosByContent
 * and listtodos with _body_ query parameters
 */
public class FilterTodosByContentFromDB {
  @Test
  public void filterTodosByContent() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] contentUllamcoTodos = db.filterTodosByContent(allTodos, "ullamco");
    assertEquals("Incorrect number of todos for content string ullamco", 71, contentUllamcoTodos.length);

    Todo[] specificTodo = db.filterTodosByContent(allTodos, "aliqua velit quis occaecat");
    assertEquals("Incorrect number of todos for for unique content string", 1, specificTodo.length);
    assertEquals("Incorrect todo id for unique content string", "5889598585bda42fb8388ba1", specificTodo[0]._id);
  }

  @Test
  public void listTodosWithContentFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("content", new String[] {"dolor nostrud"});
    Todo[] contentDolorNostrudTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos for content dolor nostrud", 3, contentDolorNostrudTodos.length);

    queryParams.put("content", new String[] {"Deserunt elit deserunt "});
    Todo[] contentDeseruntElitDeserunt = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos for unique content string", 1, contentDeseruntElitDeserunt.length);
    assertEquals("Incorrect id for unique content string", "58895985d8247e22997801c2", contentDeseruntElitDeserunt[0]._id);
  }
}
