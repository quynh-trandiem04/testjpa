package vn.iotstar.service.impl;

import java.util.List;
import vn.iotstar.dao.IUserDAO;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDAO userDao = new UserDaoImpl();

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public User findByEmail(String username) {
        return userDao.findByEmail(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(String email, String password) {
        return userDao.login(email, password);
    }

    @Override
    public boolean register(String email, String fullname, String phone, String password) {
        return userDao.register(email, fullname, phone, password);
    }
}
