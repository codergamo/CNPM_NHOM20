package Nhom20.Service;

import Nhom20.Models.*;

public interface UserService {
	AccountModel login(String username, String password);
	AccountModel get(String username);
}
