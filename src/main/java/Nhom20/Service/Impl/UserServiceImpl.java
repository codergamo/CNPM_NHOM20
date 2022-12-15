package Nhom20.Service.Impl;

import Nhom20.Dao.IAccountDao;
import Nhom20.Dao.Impl.AccountDaoImpl;
import Nhom20.Models.AccountModel;
import Nhom20.Service.UserService;
public class UserServiceImpl implements UserService {
	IAccountDao acc = new AccountDaoImpl();
	public AccountModel login(String username, String password) {
		AccountModel user = this.get(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	public AccountModel get(String username) {
		return acc.get(username);
	}
}
