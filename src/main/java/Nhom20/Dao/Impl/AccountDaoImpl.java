package Nhom20.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Nhom20.Connection.DBConnect;
import Nhom20.Dao.*;
import Nhom20.Models.*;

public class AccountDaoImpl extends DBConnect implements IAccountDao{
	@Override
	public void insert(AccountModel account) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Account(username,password,role) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getRole());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(AccountModel account) {
		String sql = "UPDATE  Account SET username=?, password=?, role=? WHERE username=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getRole());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Account WHERE username = ?";
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
	public AccountModel get(String username) {
		String sql = "SELECT * FROM Account WHERE username = '" + username +"' ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel accounter = new AccountModel();
				accounter.setUsername(rs.getString("username"));
				accounter.setPassword(rs.getString("password"));
				accounter.setRole(rs.getInt("role"));
				return accounter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountModel> getAll() {
		List<AccountModel> accounters= new ArrayList<AccountModel>();
		String sql = "SELECT * FROM account";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel accounter = new AccountModel();
				accounter.setUsername(rs.getString("username"));
				accounter.setPassword(rs.getString("password"));
				accounter.setRole(rs.getInt("role"));
				accounters.add(accounter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounters;
	}

	@Override
	public AccountModel findById(int id) {
		String sql = "SELECT * FROM account WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel accounter = new AccountModel();
				accounter.setUsername(rs.getString("username"));
				accounter.setPassword(rs.getString("password"));
				accounter.setRole(rs.getInt("role"));
				return accounter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void changePassByAdmin(AccountModel account) {
		String sql = "UPDATE  Account SET password=? WHERE username=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getPassword());
			ps.setString(2, account.getUsername());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void editPassword(AccountModel account, String nwpassword) {
		String sql = "UPDATE  Account SET username=?, password=? WHERE username=? and password=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, nwpassword);
			ps.setString(3, account.getUsername());
			ps.setString(4, account.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
