package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User readUser(long id);

    User deleteUser(long parseUnsignedInt);

    void createUser(User user, String[] role);

    void updateUser(User user, String[] role);

    User getByName(String name);

    List<Role> getRoles();
}
