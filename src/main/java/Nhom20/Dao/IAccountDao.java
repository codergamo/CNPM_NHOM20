package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.*;

public interface IAccountDao {

	void insert(AccountModel account);

	void edit(AccountModel account, String nwpassword);

	void delete(String username);

	AccountModel get(String username);

	List<AccountModel> getAll();

	AccountModel findById(String username);
}
