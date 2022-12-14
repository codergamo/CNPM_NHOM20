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
		String sql = "UPDATE  teachers SET teachersName=?, gender=?, birth=? email=?, phone=? WHERE teachersId=?";
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
	public TeachersModel get(int id) {
		String sql = "SELECT * FROM teachers WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel major = new TeachersModel();
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setteachersName(rs.getString(id));
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setBoolean(3, signup.getBoolean());
//				teacherser.setCreatedAt(rs.getDate("createdAt"));
//				teacherser.setPrice(rs.getBigDecimal("price"));
		
				return major;
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
		String sql = "SELECT * FROM teachers WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teachers = new TeachersModel();

//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setteachersName(rs.getString(id));
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setCreatedAt(rs.getDate("createdAt"));
//				teacherser.setPrice(rs.getBigDecimal("price"));
				
				return teachers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
