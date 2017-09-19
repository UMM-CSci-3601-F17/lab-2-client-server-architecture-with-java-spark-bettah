package umm3601.todo;


import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FilterTodoByOwnerFromDB {

  @Test
  public void filterTodosByOwner() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] ownerBarryTodos = db.filterTodosByOwner(allTodos, "Barry");
    assertEquals("Incorrect number of todos for owner Barry", 51, ownerBarryTodos.length);

    Todo[] ownerDawnTodos = db.filterTodosByOwner(allTodos, "Dawn");
    assertEquals("Incorrect number of todos for ownwer Dawn", 50, ownerDawnTodos.length);
  }

  @Test
  public void listTodosWithOwnerFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[]{"Barry"});
    Todo[] ownerBarryTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos for owner Barry", 51, ownerBarryTodos.length);

    queryParams.put("owner", new String[]{"Dawn"});
    Todo[] ownerDawnTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos for owner Dawn", 50, ownerDawnTodos.length);
  }

}
