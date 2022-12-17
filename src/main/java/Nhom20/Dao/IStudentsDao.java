package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.StudentsModel;

public interface IStudentsDao {

	StudentsModel findById(int id);

	void insert(StudentsModel students);

	void edit(StudentsModel students);

	void delete(int id);

	StudentsModel get(int id);

	List<StudentsModel> getAll();
	
	List<StudentsModel> getListSearh(String key, int idPage);

	StudentsModel findStudentByEmail(String email);

	String findTopicIdByEmail(String email);

	List<StudentsModel> getAllByAdmin();

}
