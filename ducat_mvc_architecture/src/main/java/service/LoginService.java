package service;

import dao.LoginDao;
import model.User;

public class LoginService {

	
	
	public User LoginService(String email ,String password) {
		LoginDao logDao = new LoginDao();
		User user =logDao.LoginDao(email, password);
		
		
		return user;
	}
}
