package umm3601.todo;

import org.junit.Test;
import umm3601.entries.Todo;
import umm3601.entries.Database;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OrderTodosFromDB {

  @Test
  //This test is not automated
  public void orderTodosManually() throws IOException {

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

  @Test
  //This Test is automated
  public void orderTodoByBody() throws IOException {
    boolean decendingOrder = true;

    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoBodyOrdered = db.orderTodos(allTodos, "body");
    for (int i = 0; i < todoBodyOrdered.length -1; i++) {
      if (todoBodyOrdered[i].body.compareTo(todoBodyOrdered[i + 1].body) > 0) {
        decendingOrder = false;
      }
    }
    assertEquals("The order of Todos that was given was not decending", decendingOrder, true);
  }
}
