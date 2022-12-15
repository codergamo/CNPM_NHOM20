package Nhom20.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Nhom20.Connection.*;
import Nhom20.Dao.*;
import Nhom20.Models.*;

public class TopicDaoImpl extends DBConnect implements ITopicDao{
	@Override
	public void insert(TopicModel topic) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Topic(topicName,teacherId,detail,createAt) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, topic.getTopicName());
			ps.setInt(2,topic.getTeacherId());
			ps.setString(3, topic.getDetail());
			ps.setDate(4, Date.valueOf(LocalDate.now()));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(TopicModel topic) {
		String sql = "UPDATE  topic SET topicName=?, gender=?, birth=? email=?, phone=? WHERE topicId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, topic.gettopicName());
//			ps.setBoolean(2, topic.getGender());
//			ps.setDate(3, topic.getBirth());
//			ps.setInt(6, topic.gettopicId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM topic WHERE topicId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public TopicModel get(int id) {
		String sql = "SELECT * FROM Topic WHERE topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
		
				return topic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TopicModel> getAll() {
		List<TopicModel> topics = new ArrayList<TopicModel>();
		String sql = "SELECT * FROM Topic";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
				
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

	@Override
	public TopicModel findById(int id) {
		String sql = "SELECT * FROM Topic WHERE topicId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
		
				return topic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TopicModel> getAllByTeacher(int teacherId)
	{
		List<TopicModel> topics = new ArrayList<TopicModel>();
		String sql = "SELECT * FROM Topic where teacherId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, teacherId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}
	@Override
	public List<TopicModel> findTopicByEmail(String email) {
		String sql = "select Topic.topicId, Topic.topicName, Topic.teacherId, Topic.detail, Topic.createAt, Topic.link \r\n"
				+ "from Topic, Teachers, Students, Majors, Account\r\n"
				+ "where Teachers.teacherId = Topic.teacherId and Teachers.majorId=Majors.majorId\r\n"
				+ "and Students.majorId=Majors.majorId and Students.email=Account.username "
				+ "and Account.username=?";
		List<TopicModel> topics = new  ArrayList<TopicModel>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTeacherId(rs.getInt("teacherId"));
				topic.setDetail(rs.getString("detail"));
				topic.setCreateAt(rs.getDate("createAt"));
				topic.setLink(rs.getString("link"));
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}
}
