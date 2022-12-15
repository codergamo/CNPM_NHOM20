package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.TopicDetailsModel;

public interface ITopicDetailsDao {

	void insert(TopicDetailsModel topicdetails);

	void edit(TopicDetailsModel topicdetails);

	void delete(int id);

	TopicDetailsModel get(int id);

	List<TopicDetailsModel> getAll();

	TopicDetailsModel findById(int id);

	List<TopicDetailsModel> findTopicDetailByTopicId(int topicId);

	String findMajorNameByTopicDetail(int topicId);

	void insertMenber(TopicDetailsModel topicdetail);

	void insertLeader(TopicDetailsModel topicdetail);

}
