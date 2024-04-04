package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User readUser(long id);

    void deleteUser(long id);

    void createUser(User user, String[] role);

    void createUser(User user);

    void updateUser(User user, String[] role);
    void updateUser(User user);

    User getByName(String name);

    List<Role> getRoles();

}
