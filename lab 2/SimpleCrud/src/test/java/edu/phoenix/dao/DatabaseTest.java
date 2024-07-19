package edu.phoenix.dao;

import edu.phoenix.exception.EmptyFieldsException;
import edu.phoenix.exception.UserNotFoundException;
import edu.phoenix.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
  private static final String NAME = "name";
  private static final String LOGIN = "login";
  private static final String PASSWORD = "password";

  @Test
  void shouldAddUser() {
    assertTrue(Database.dataBase.isEmpty());

    try {
      Database.addUser(NAME, LOGIN, PASSWORD);
      assertEquals(1, Database.dataBase.size());

      User user = Database.dataBase.get(0);

      assertEquals(NAME, user.getName());
      assertEquals(LOGIN, user.getLogin());
      assertEquals(PASSWORD, user.getPassword());

      Database.dataBase.remove(0);

    }
    catch (EmptyFieldsException ex) {
      ArrayList<String> emptyFields = ex.getEmptyFieldsList();
      System.out.println(ex.getMessage());
      for(String emptyField : emptyFields) System.out.println(emptyField);
    }

    assertTrue(Database.dataBase.isEmpty());

  }

  @Test
  void shouldReturnUser() {
    assertTrue(Database.dataBase.isEmpty());
    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));
    try {
      User user = Database.getUser(LOGIN, PASSWORD);

      assertNotNull(user);

      assertEquals(NAME, user.getName());
      assertEquals(LOGIN, user.getLogin());
      assertEquals(PASSWORD, user.getPassword());

      Database.dataBase.remove(0);


    }
    catch (UserNotFoundException ex){
      System.out.println(ex.getMessage());
    }

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void shouldDeleteUser() {
    assertTrue(Database.dataBase.isEmpty());

    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));

    Database.deleteUser(LOGIN);

    assertTrue(Database.dataBase.isEmpty());
  }

  @Test
  void shouldUpdateUser() {
    assertTrue(Database.dataBase.isEmpty());

    Database.dataBase.add(new User(NAME, LOGIN, PASSWORD));

    String updatedName = "new name";
    String updatedPassword = "new password";

    User updated = new User(updatedName, LOGIN, updatedPassword);

    Database.updateUser(updated);

    User fromDB = Database.dataBase.get(0);

    assertEquals(updatedName, fromDB.getName());
    assertEquals(updatedPassword, fromDB.getPassword());

    Database.dataBase.remove(0);

    assertTrue(Database.dataBase.isEmpty());
  }
}