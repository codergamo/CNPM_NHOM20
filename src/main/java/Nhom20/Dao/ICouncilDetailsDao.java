package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.CouncilDetailsModel;

public interface ICouncilDetailsDao {

	void insert(CouncilDetailsModel councildetail);

	void edit(CouncilDetailsModel councildetail);

	void delete(int councilId, int teacherId);

	CouncilDetailsModel get(int id);

	List<CouncilDetailsModel> getAll();

	CouncilDetailsModel findById(int id);

	String findByCouncilId(int topicId);

	List<CouncilDetailsModel> getAllTeacherByCouncilId(int councilId);

	List<CouncilDetailsModel> getAllByTeacher(int teacherId);

	List<CouncilDetailsModel> getAllByCouncilId(int councilId);
	
	void updateScoresCounCilDetail(float scores, int councilId, int teacherId,int topicId);


}
