package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.SignUpModel;

public interface ISignUpDao {

	void insert(SignUpModel signup);

	SignUpModel findById(int id);

	List<SignUpModel> getAll();

	SignUpModel get(int id);

	void delete(int id);

	void edit(SignUpModel signup);
}
