package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.CouncilDetailsModel;

public interface ICouncilDetailsDao {
	void insert(CouncilDetailsModel councildetail);

	void edit(CouncilDetailsModel councildetail);

	void delete(int id);

	CouncilDetailsModel get(int id);

	List<CouncilDetailsModel> getAll();

	CouncilDetailsModel findById(int id);
	
	List<CouncilDetailsModel> getAllByTeacher(int teacherId);

	List<CouncilDetailsModel> getAllByCouncilId(int councilId);

	List<CouncilDetailsModel> getAllTeacherByCouncilId(int councilId);

	String findByCouncilId(int topicId);
}
