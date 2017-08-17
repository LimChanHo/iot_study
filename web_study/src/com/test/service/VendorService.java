package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorService {


	public List<Vendor> selectVendorsList(String viName){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			if(viName!=null){
				sql += " and viname like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(viName!=null){
				ps.setString(1, "%" + viName + "%");
			}
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendorList.add(vendor);
			}
			return vendorList;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int insertVendor(String viName,String viDesc,String viAddress,String viPhone){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into vendor_info(viName,viDesc, viAddress, viPhone, vicredat, vicretim)";
			sql += " values(?,?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, viName);
			ps.setString(2, viDesc);
			ps.setString(3, viAddress);
			ps.setString(4, viPhone);
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updateVendor(int viNum, String viName,String viDesc,String viAddress,String viPhone){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update vendor_info";
			sql += " set viname=?,";
			sql += " videsc=?,";
			sql += " viaddress=?,";
			sql += " viphone=?";
			sql += " where vinum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, viName);
			ps.setString(2, viDesc);
			ps.setString(3, viAddress);
			ps.setString(4, viPhone);
			ps.setInt(5, viNum);
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteVendor(int viNum){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from vendor_info where vinum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, viNum);
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Vendor viewVendor(int viNum){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone "
					+ " from vendor_info"
					+ " where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, viNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				return vendor;
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
