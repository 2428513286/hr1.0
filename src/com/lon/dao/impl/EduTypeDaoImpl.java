package com.lon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lon.dao.EduTypeDao;
import com.lon.entity.EduType;
import com.lon.util.DBUtils;

public class EduTypeDaoImpl implements EduTypeDao{

		@Override
		public void add(EduType eduType) {
			Connection con = com.lon.util.DBUtils.getConnection();
			PreparedStatement pst = null;
			String sql = "insert into hr_edu_type(name) values(?)";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, eduType.getName());
				
				System.out.println("成功新增【"+pst.executeUpdate()+"】条记录");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, null);
			}
		}

		@Override
		public void addMore(List<EduType> list) {
			Connection con = com.lon.util.DBUtils.getConnection();
			PreparedStatement pst = null;
			String sql = "insert into hr_edu_type(name) values(?)";
			try {
				pst=con.prepareStatement(sql);
				for(int i=0;i<list.size();i++) {
					EduType a = list.get(i);
					pst.setString(1, a.getName());
					
					pst.addBatch();
					if(i%300==0) {
						pst.executeBatch();
						pst.clearBatch();
					}
				}
				pst.executeBatch();
				pst.clearBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, null);
			}
			
		}

		@Override
		public void deleteById(int id) {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			String sql = "delete from hr_edu_type where id=?";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				System.out.println("成功删除【"+pst.executeUpdate()+"】条记录");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, null);
			}
		}

		public void deleteMore(String ids) {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			String sql = "delete from hr_edu_type where id in ("+ids+")";
			try {
				pst = con.prepareStatement(sql);
				System.out.println("成功删除【"+pst.executeUpdate()+"】条记录");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, null);
			}
		}

		@Override
		public void update(EduType eduType) {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			String sql = "update hr_edu_type set name=? where id=?";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, eduType.getName());
				pst.setInt(2, eduType.getId());
				System.out.println("成功更新【"+pst.executeUpdate()+"】条记录");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, null);
			}
		}

		@Override
		public EduType queryById(int id) {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			EduType a = null;
			String sql = "select * from hr_edu_type where id=?";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()) {
					a = new EduType();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return a;
		}

		@Override
		public List<EduType> queryAll() {
			List<EduType> list = new ArrayList<>();
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select * from hr_edu_type order by id";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					EduType a = new EduType();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					list.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return list;
		}

		@Override
		public List<EduType> queryByPage(int currentPage, int pageSize) {
			List<EduType> list = new ArrayList<>();
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select * from hr_edu_type order by id limit ?,?";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, (currentPage-1)*pageSize);
				pst.setInt(2, pageSize);
				rs = pst.executeQuery();
				while(rs.next()) {
					EduType a = new EduType();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					list.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return list;
		}

		@Override
		public List<EduType> queryByPage(int currentPage, int pageSize, String condition) {
			List<EduType> list = new ArrayList<>();
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select * from hr_edu_type "+condition+" order by id limit ?,?";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, (currentPage-1)*pageSize);
				pst.setInt(2, pageSize);
				rs = pst.executeQuery();
				while(rs.next()) {
					EduType a = new EduType();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					list.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return list;
		}

		@Override
		public int getTotals() {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select count(*) from hr_edu_type";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return 0;
		}

		@Override
		public int getTotals(String condition) {
			Connection con = DBUtils.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select count(*) from hr_edu_type "+condition;
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.close(con, pst, rs);
			}
			return 0;
		}
}
