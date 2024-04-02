package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {

    void createUser(User user, String[] roles);

    User readUser(long id);

    void updateUser(User user, String[] roles);

    List<User> getUsers();

    User deleteUser(long id);
    User getByName(String name);

    List<Role> getRoles();

}
