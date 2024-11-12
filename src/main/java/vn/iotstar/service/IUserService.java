package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserService {
	User get(int id);
	void insert(User user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	User findByEmail(String username);
	public List<User> findAll();
	User login(String email, String password);
	boolean register(String email, String fullname, String phone, String password);
}