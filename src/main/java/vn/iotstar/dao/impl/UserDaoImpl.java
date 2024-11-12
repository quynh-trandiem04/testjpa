package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import vn.iotstar.dao.*;
import vn.iotstar.entity.User;
import java.util.List;

public class UserDaoImpl implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void insert(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean checkExistEmail(String email) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
        Long count = entityManager.createQuery(query, Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.username = :username";
        Long count = entityManager.createQuery(query, Long.class)
                .setParameter("username", username)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.phone = :phone";
        Long count = entityManager.createQuery(query, Long.class)
                .setParameter("phone", phone)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT u FROM User u WHERE u.email = :email";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("email", email);
        return typedQuery.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT u FROM User u";
        return entityManager.createQuery(query, User.class).getResultList();
    }

    @Override
    public User login(String email, String password) {
        String query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("email", email);
        typedQuery.setParameter("password", password);
        return typedQuery.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public boolean register(String email, String fullname, String phone, String password) {
        if (checkExistEmail(email)) {
            return false;
        }
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullname);
        user.setPhone(phone);
        user.setPassWord(password);
        insert(user);
        return true;
    }
}
