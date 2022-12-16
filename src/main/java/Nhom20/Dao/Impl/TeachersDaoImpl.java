package Nhom20.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Nhom20.Connection.*;
import Nhom20.Dao.*;
import Nhom20.Models.*;

public class TeachersDaoImpl extends DBConnect implements ITeachersDao{
	@Override
	public void insert(TeachersModel teachers) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO teachers(teachersName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
//			ps.setString(1, teachers.getteachersName());
//			ps.setBoolean(2, teachers.getGender());
//			ps.setDate(3, teachers.getBirth());
//			ps.setInt(6, teachers.getteachersId());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(TeachersModel teachers) {

		String sql = "UPDATE  teachers SET teacherName=?, gender=?, birth=?, phone=? WHERE email=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, teachers.getTeacherName());
			ps.setBoolean(2, teachers.getGender());
			ps.setDate(3, teachers.getBirth());
			ps.setString(4, teachers.getPhone());
			ps.setString(5, teachers.getEmail());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM teachers WHERE teachersId = ?";
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
	public TeachersModel getByUser(String user) {
		String sql = "SELECT * FROM teachers WHERE email = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int teacherId = rs.getInt("teacherId");
			    String teacherName = rs.getString("teacherName");
			    Boolean gender = rs.getBoolean("gender");
			    Date birth  = rs.getDate("birth");;
			    String email = rs.getString("email");
			    String phone = rs.getString("phone");
				int majorId = rs.getInt("majorId");
				
				return new TeachersModel(teacherId,teacherName,gender,birth,email,phone,majorId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TeachersModel> getAll() {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "SELECT * FROM teachers";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel major = new TeachersModel();
				
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setteachersName(rs.getString(id));
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setBoolean(3, signup.getBoolean());
//				teacherser.setCreatedAt(rs.getDate("createdAt"));
//				teacherser.setPrice(rs.getBigDecimal("price"));
				
				teachers.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public TeachersModel findById(int id) {


		String sql = "SELECT * FROM teachers WHERE teacherId = ? ";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				TeachersModel teacher = new TeachersModel();

				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setGender(rs.getBoolean("gender"));
				teacher.setBirth(rs.getDate("birth"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMajorId(rs.getInt("majorId"));
				
				return teacher;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public TeachersModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeachersModel> getListSearh(String key) {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "DECLARE @value nvarchar(50)\r\n"
				+ "set @value= N'%" + key +"%'\r\n"
				+ "select Teachers.teacherId, Teachers.teacherName, Teachers.phone, Teachers.email,\r\n"
				+ "(select Majors.majorName from Majors where Majors.majorId = Teachers.majorId) as majorName,\r\n"
				+ "(select Topic.topicName from Topic  where Teachers.teacherId = Topic.teacherId) as topicName\r\n"
				+ "from Teachers\r\n"
				+ "where Teachers.teacherName like @value \r\n"
				+ "or Teachers.teacherId like @value \r\n"
				+ "or Teachers.phone  like @value\r\n"
				+ "or Teachers.email  like @value";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();
				
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setEmail(rs.getString("email"));
				
				/*
				 * teacher.setTopicName(rs.getString("topicName"));
				 * teacher.setMajorName(rs.getString("majorName"));
				 */
				
				teachers.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public List<TeachersModel> getAllTeacherCouncil(int teacherId) {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "SELECT Teachers.teacherId, Teachers.teacherName, Teachers.email, Teachers.phone, Majors.majorName\r\n"
				+ "FROM Teachers, Majors \r\n"
				+ "Where Teachers.majorId = Majors.majorId";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();
				
				if(rs.getInt("teacherId") != teacherId) {
					teacher.setTeacherId(rs.getInt("teacherId"));
					teacher.setTeacherName(rs.getString("teacherName"));
					teacher.setEmail(rs.getString("email"));
					teacher.setPhone(rs.getString("phone"));
					/* teacher.setMajorName(rs.getString("majorName")); */
					
					teachers.add(teacher);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}



	
}
