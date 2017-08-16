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

	public List<Vendor> selectVendorList(Vendor pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone"
					+ " from vendor_info"
					+ " order by vinum"
					+ " limit ?,?";
			Page page = pGoods.getPage();
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, page.getStartRow());
			System.out.println(page.getStartRow());
			ps.setInt(2, page.getRowCnt());
			System.out.println(page.getBlockCnt());
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

	public int getTotalCount(Vendor pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) "
					+ " from vendor_info as gi, vendor_info";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next()){
				return rs.getInt(1);
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
		return 0;
	}
	
	public Vendor selectVendor(Vendor pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone "
					+ " from vendor_info"
					+ " where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getViNum());
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
