package ru.itmentor.spring.boot_security.demo.services;

import ru.itmentor.spring.boot_security.demo.dao.UserDaoHibernateImpl;
import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public void deleteUser(long id) {
        userDaoHibernate.deleteUser(id);
    }

    @Override
    public void createUser(User user, String[] role) {
        userDaoHibernate.createUser(user, role);
    }

    @Override
    public void createUser(User user) {
        userDaoHibernate.createUser(user);
    }

    @Override
    public void updateUser(User user, String[] role) {
        userDaoHibernate.updateUser(user, role);
    }

    @Override
    public void updateUser(User user) {
        userDaoHibernate.updateUser(user);
    }

    @Override
    public User getByName(String name) {
        return userDaoHibernate.getByName(name);
    }

    @Override
    public List<Role> getRoles() {
        return userDaoHibernate.getRoles();
    }

//    @Override
//    public Set<Role> getSetOfRoles(List<String> rolesId){
//        Set<Role> roleSet = new HashSet<>();
//        for (String id: rolesId) {
//            roleSet.add(roleServices.getRoleById(Long.parseLong(id)));
//        }
//        return roleSet;
//    }
}
