package mvc.service;

import mvc.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(int id);

    void addUser(User customer);

    void updateUser(User customer);

    void deleteUser(int id);

}
