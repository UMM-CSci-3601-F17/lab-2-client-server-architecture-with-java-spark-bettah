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
   // limits filteredTodos from 3 to 2
   filteredTodos = db.limitTodos(filteredTodos, 2);
   filteredTodos = db.orderTodos(filteredTodos, "body");


    // Note that filteredTodos should now contain only 2 Todos, so we resort to checking both for their properties.

    //Checks Limit filter
    assertEquals("Incorrect Length", 2, filteredTodos.length);

    //Checks Status filter
    assertEquals("Incorrect Status",true,filteredTodos[0].status);
    assertEquals("Incorrect Status",true,filteredTodos[1].status);

    //Checks category filter
    assertEquals("Incorrect Category","groceries",filteredTodos[0].category);
    assertEquals("Incorrect Category","groceries",filteredTodos[1].category);

    //Checks body filter
    assertEquals("Incorrect Content",true,filteredTodos[0].body.contains("dolor"));
    assertEquals("Incorrect Content",true,filteredTodos[1].body.contains("dolor"));

    //Checks owner filter
    assertEquals("Incorrect Owner","Barry",filteredTodos[0].owner);
    assertEquals("Incorrect Owner","Barry",filteredTodos[1].owner);

    //Checks expected order
    assertEquals("Incorrect order", true, (filteredTodos[0].body.compareTo(filteredTodos[1].body) < 0));

  }
}
