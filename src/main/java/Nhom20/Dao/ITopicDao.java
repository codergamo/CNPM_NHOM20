package Nhom20.Dao;

import java.util.List;

import Nhom20.Models.TopicModel;

public interface ITopicDao {
	void insert(TopicModel topic);

	void edit(TopicModel topic);

	void delete(int id);

	TopicModel get(int id);

	List<TopicModel> getAll();

	TopicModel findById(int id);
}
