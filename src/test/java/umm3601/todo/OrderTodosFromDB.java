package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Database;
import umm3601.entries.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OrderTodosFromDB {



  /**
   * Tests umm3601.todo.Database orderTodos
   * and listtodos with _order_ query parameters
   */
 // @Test

  //This test is not automated
  public void listTodosAlphabetically() throws IOException {

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoOwnerOrdered = db.orderTodos(allTodos, "owner");
    for (int i = 0; i < todoOwnerOrdered.length; i++) {
      System.out.println(todoOwnerOrdered[i].owner);
    }

    Todo[] todoStatusOrdered = db.orderTodos(allTodos, "status");
    for (int i = 0; i < todoStatusOrdered.length; i++) {
      System.out.println(todoStatusOrdered[i].status);
    }

    Todo[] todoBodyOrdered = db.orderTodos(allTodos, "body");
    for (int i = 0; i < todoBodyOrdered.length; i++) {
      System.out.println(todoStatusOrdered[i].body);
    }

    Todo[] todoCategoryOrdered = db.orderTodos(allTodos, "category");
    for (int i = 0; i < todoCategoryOrdered.length; i++) {
      System.out.println(todoCategoryOrdered[i].category);
    }
  }

  /* Redundant test
  @Test
  public void listTodosAlphabeticallyAuto() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoOwnerOrdered = db.orderTodos(allTodos, "owner");
    for (int i = 0; i < todoOwnerOrdered.length; i++) {
      if(i > 1) {
       assertTrue("Out of order comparison", (0 <= todoOwnerOrdered[i].owner.compareTo(todoOwnerOrdered[i - 1].owner)));
      }
    }

    Todo[] todoStatusOrdered = db.orderTodos(allTodos, "status");
    for (int i = 0; i < todoStatusOrdered.length; i++) {
      if(i > 1) {
        assertTrue("Out of order comparison", (0 >= todoStatusOrdered[i].status.compareTo(todoStatusOrdered[i - 1].status)));
      }
    }
  }
  */

  @Test
  //This Test is automated
  public void orderTodoByBody() throws IOException {
    boolean ascendingOrder = true;

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoBodyOrdered = db.orderTodos(allTodos, "body");
    for (int i = 0; i < todoBodyOrdered.length - 1; i++) {
      if (todoBodyOrdered[i].body.compareTo(todoBodyOrdered[i + 1].body) > 0) {
        ascendingOrder = false;
      }
    }
    assertEquals("The Todos are not in ascending order", true, ascendingOrder);
  }

  @Test
  //This Test is automated
  public void orderTodoByOwner() throws IOException {
    boolean ascendingOrder = true;

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoOwnerOrdered = db.orderTodos(allTodos, "owner");
    for (int i = 0; i < todoOwnerOrdered.length - 1; i++) {
      if (todoOwnerOrdered[i].owner.compareTo(todoOwnerOrdered[i + 1].owner) > 0) {
        ascendingOrder = false;
      }
    }
    assertEquals("The Todos are not in ascending order", true, ascendingOrder);
  }

  @Test
  //This Test is automated
  public void orderTodoByCategory() throws IOException{
    boolean ascendingOrder = true;

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoCategoryOrdered = db.orderTodos(allTodos, "category");
    for (int i = 0; i < todoCategoryOrdered.length - 1; i++) {
      if (todoCategoryOrdered[i].category.compareTo(todoCategoryOrdered[i + 1].category) > 0) {
        ascendingOrder = false;
      }
    }
    assertEquals("The Todos are not in ascending order", true, ascendingOrder);
  }

  @Test
  //This Test is automated
  public void orderTodoByStatus() throws IOException {
    boolean ascendingOrder = true;

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoStatusOrdered = db.orderTodos(allTodos, "status");
    for (int i = 0; i < todoStatusOrdered.length - 1; i++) {
      if (Boolean.compare(todoStatusOrdered[i].status, todoStatusOrdered[i + 1].status) > 0) {
        ascendingOrder = false;
      }
    }
    assertEquals("The Todos are not in ascending order", true, ascendingOrder);
  }

}
