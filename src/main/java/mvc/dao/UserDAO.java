package mvc.dao;

import mvc.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    User getUser(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
