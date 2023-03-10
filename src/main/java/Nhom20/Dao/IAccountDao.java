package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.AccountModel;

public interface IAccountDao {

	void insert(AccountModel account);

	void edit(AccountModel account);

	void delete(int id);

	AccountModel get(String username);

	AccountModel findById(int id);

	List<AccountModel> getAll();

	void changePassByAdmin(AccountModel account);

	void editPassword(AccountModel account, String nwpassword);

}
