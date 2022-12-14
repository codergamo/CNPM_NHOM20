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
}
