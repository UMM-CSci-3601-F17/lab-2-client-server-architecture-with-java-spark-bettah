package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FilterTodosWithMultipleConstraintsFromDB {


  @Test
  public void testAllFilters() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] filteredTodos = allTodos;

   filteredTodos = db.filterTodosByStatus(filteredTodos, true);
   filteredTodos = db.filterTodosByCategory(filteredTodos, "groceries");
   filteredTodos = db.filterTodosByContent(filteredTodos, "dolor");
   filteredTodos = db.filterTodosByOwner(filteredTodos, "Barry");
   // limits filteredTodos from what would be length 3 to 2
   filteredTodos = db.limitTodos(filteredTodos, 2);
   filteredTodos = db.orderTodos(filteredTodos, "body");


    // Note that filteredTodos should now contain only 2 Todos, so we resort to checking both for their properties.

    //Checks Limit filter
    assertEquals("Incorrect Length of filteredTodos", 2, filteredTodos.length);

    //Checks Status filter
    assertEquals("Incorrect Status of Todo found",true,filteredTodos[0].status);
    assertEquals("Incorrect Status of Todo found",true,filteredTodos[1].status);

    //Checks category filter
    assertEquals("Incorrect Category of Todo found","groceries",filteredTodos[0].category);
    assertEquals("Incorrect Category of Todo found","groceries",filteredTodos[1].category);

    //Checks body filter
    assertEquals("Incorrect Content of Todo found",true,filteredTodos[0].body.contains("dolor"));
    assertEquals("Incorrect Content of Todo found",true,filteredTodos[1].body.contains("dolor"));

    //Checks owner filter
    assertEquals("Incorrect Owner of Todo found","Barry",filteredTodos[0].owner);
    assertEquals("Incorrect Owner of Todo found","Barry",filteredTodos[1].owner);

    //Checks expected order
    assertEquals("Incorrect order of Todos found", true, (filteredTodos[0].body.compareTo(filteredTodos[1].body) < 0));

  }

  @Test
  public void testMultipleQueryParams() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();
    boolean todoFilterError = false;

    queryParams.put("status", new String[] {"true"});
    queryParams.put("owner", new String[] {"Dawn"});

    Todo[] DawnCompletedTasks = db.listTodos(queryParams);


    for (int i = 0; i < DawnCompletedTasks.length; i++) {
       if (DawnCompletedTasks[i].status != true || DawnCompletedTasks[i].owner != "Dawn") {
         todoFilterError = true;
       }
       assertEquals("Incorrect property of Todo found", true, todoFilterError);
    }
  }
}
