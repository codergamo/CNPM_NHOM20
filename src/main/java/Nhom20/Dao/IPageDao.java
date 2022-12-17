package Nhom20.Dao;

import Nhom20.Models.PageModel;

public interface IPageDao {

	PageModel PageStudent(String key);
	PageModel PageTeacher(String key);
	PageModel PageTopic(String key);
}
