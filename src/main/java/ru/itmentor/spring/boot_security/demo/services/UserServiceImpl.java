package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.dao.UserDaoHibernateImpl;
import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDaoHibernateImpl userDaoHibernate;

    public UserServiceImpl(UserDaoHibernateImpl userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }

    @Override
    public List<User> getUsers() {
        return userDaoHibernate.getUsers();
    }

    @Override
    public User readUser(long id) {
        return userDaoHibernate.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDaoHibernate.deleteUser(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user, String[] role) {
        userDaoHibernate.createUser(user, role);
    }

    @Override
    public void updateUser(User user, String[] role) {
        userDaoHibernate.updateUser(user, role);
    }

    @Override
    public User getByName(String name) {
        return userDaoHibernate.getByName(name);
    }

    @Override
    public List<Role> getRoles() {
        return userDaoHibernate.getRoles();
    }
}
