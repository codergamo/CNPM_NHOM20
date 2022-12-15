package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.TeachersModel;

public interface ITeachersDao {

	void insert(TeachersModel teachers);

	void edit(TeachersModel teachers);

	void delete(int id);


	TeachersModel getByUser(String user);

	TeachersModel get(int id);


	List<TeachersModel> getAll();

	TeachersModel findById(int id);

}
