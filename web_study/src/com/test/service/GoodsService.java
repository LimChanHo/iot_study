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

public class GoodsService {
	public List<Vendor> selectVendorsList(){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname from vendor_info";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
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
	public List<Goods> selectGoodsList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum";

			int idx=0;
			if(pGoods.getViNum()!=0){
				sql += " and gi.vinum=?";
				idx++;
			}
			if(pGoods.getGiName()!=null){
				sql += " and gi.giname like ?";
				idx++;
			}
			sql += " order by gi.ginum desc";
			sql += " limit ?,?";
			Page page = pGoods.getPage();
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(pGoods.getViNum()!=0 && pGoods.getGiName()==null){
				ps.setInt(1, pGoods.getViNum());
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()==0){
				ps.setString(1, "%" + pGoods.getGiName() + "%");
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()!=0 ){
				ps.setInt(1, pGoods.getViNum());
				ps.setString(2, "%" + pGoods.getGiName() + "%");
			}
			ps.setInt(++idx, page.getStartRow()); 
			ps.setInt(++idx, page.getRowCnt());
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("ginum"));
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				goodsList.add(goods);
			}
			return goodsList;
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

	public int deleteGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from goods_info where  ginum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
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

	public int insertGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into goods_info(giname, gidesc, vinum, gicredat, gicretim)";
			sql += " values(?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3, pGoods.getViNum());
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

	public int updateGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update goods_info";
			sql += " set giname=?,";
			sql += " gidesc=?,";
			sql += " vinum=?";
			sql += " where ginum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pGoods.getGiName());
			ps.setString(2, pGoods.getGiDesc());
			ps.setInt(3, pGoods.getViNum());
			ps.setInt(4, pGoods.getGiNum());
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
	public Goods selectGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum and gi.ginum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("ginum"));
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				return goods;
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
	public int getTotalCount(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum";
			if(pGoods.getViNum()!=0){
				sql += " and gi.vinum=?";
			}
			if(pGoods.getGiName()!=null){
				sql += " and gi.giname like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(pGoods.getViNum()!=0 && pGoods.getGiName()==null){
				ps.setInt(1, pGoods.getViNum());
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()==0){
				ps.setString(1, "%" + pGoods.getGiName() + "%");
			}else if(pGoods.getGiName()!=null && pGoods.getViNum()!=0 ){
				ps.setInt(1, pGoods.getViNum());
				ps.setString(2, "%" + pGoods.getGiName() + "%");
			}
			
			ResultSet rs = ps.executeQuery();
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
}
