package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user, String[] roles) {
        entityManager.persist(createUserWithRoles(user, roles));
        entityManager.flush();
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    private User createUserWithRoles(User user, String[] roles){
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setLastname(user.getLastname());
        newUser.setAge(user.getAge());

        List<String> userRoles = Arrays.asList(roles);
        getRoles().forEach(role -> {
            if (userRoles.contains(role.getRole())) {
                newUser.addRole(role);
            }
        });
        return newUser;
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user, String[] role) {
        entityManager.merge(createUserWithRoles(user, role));
        entityManager.flush();
    }

    @Override
    public User deleteUser(long id) throws EntityNotFoundException {
        User user = readUser(id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }

    @Override
    public User getByName(String name) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
