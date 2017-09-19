package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Database;
import umm3601.entries.Todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.Database filterTodosByCategory
 * and listtodos with _category_ query parameters
 */

public class FilterTodoByCategoryFromDB {

    @Test
    public void filterTodosByCategory() throws IOException {
      Database db = new Database("src/main/data/todos.json");
      Todo[] allTodos = db.listTodos(new HashMap<>());

      Todo[] categoryHomeworkTodos = db.filterTodosByCategory(allTodos, "homework");
      assertEquals("Incorrect number of todos for status homework", 79, categoryHomeworkTodos.length);

      Todo[] categoryVideoGamesTodos = db.filterTodosByCategory(allTodos, "video games");
      assertEquals("Incorrect number of todos for category video games", 71, categoryVideoGamesTodos.length);
    }

    @Test
    public void listtodosWithAgeFilter() throws IOException {
      Database db = new Database("src/main/data/todos.json");
      Map<String, String[]> queryParams = new HashMap<>();

      queryParams.put("category", new String[] {"groceries"});
      Todo[] categoryGroceriesTodos = db.listTodos(queryParams);
      assertEquals("Incorrect number of todos for category groceries", 76, categoryGroceriesTodos.length);

      queryParams.put("category", new String[] {"software design"});
      Todo[] categorySoftwareDesignTodos = db.listTodos(queryParams);
      assertEquals("Incorrect number of todos for category software design", 74, categorySoftwareDesignTodos.length);
    }
}


