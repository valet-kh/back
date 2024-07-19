package edu.phoenix.dao;

import edu.phoenix.exception.EmptyFieldsException;
import edu.phoenix.exception.UserNotFoundException;
import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public static List<User> dataBase = new ArrayList<>();

  public static void addUser(String name, String login, String password) throws EmptyFieldsException {
    ArrayList<String> emptyFieldsList = new ArrayList<>();
    if (name.isEmpty()) emptyFieldsList.add("name");
    if (login.isEmpty()) emptyFieldsList.add("login");
    if (password.isEmpty()) emptyFieldsList.add("password");

    if (!emptyFieldsList.isEmpty()) throw new EmptyFieldsException("Невозможно записать пользователя, есть пустые поля:", emptyFieldsList);
    dataBase.add(new User(name, login, password));
  }

  public static User getUser(String login, String password) throws UserNotFoundException {
    for(User user : dataBase) {
      if (user.getPassword().equals(password) && user.getLogin().equals(login)){
        return user;
      }
    }
    throw new UserNotFoundException("Пользователь с данными логином и паролем не был найден.");
  }

  public static void deleteUser(String login) {
      dataBase.removeIf(user -> user.getLogin().equals(login));
  }

  public static void updateUser(User user) {
    for(User tempUser : dataBase) {
      if (tempUser.getLogin().equals(user.getLogin())){
        int indexToReplace = dataBase.indexOf(tempUser);
        dataBase.set(indexToReplace, user);
        break;
      }
    }

  }

}
