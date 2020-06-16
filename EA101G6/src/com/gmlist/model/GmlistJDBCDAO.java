package com.gmlist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gmlist.model.GmlistDAO_interface;

public class GmlistJDBCDAO implements GmlistDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BOARD_GAME";
	String passwd = "123456";

	private static final String INSERT_STMT = 
		"INSERT INTO gmlist (gmno, shopno) VALUES (?, ?)";
	private static final String DELETE = 
		"DELETE FROM gmlist where gmno = ? AND shopno = ?";	
	private static final String GET_GMLIST_BY_GAME =
			"SELECT gmno,shopno FROM gmlist where gmno = ?";
	private static final String GET_GMLIST_BY_SHOP =
			"SELECT gmno,shopno FROM gmlist where shopno = ?";		
			
	@Override
	public void insert(GmlistVO gmlistVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, gmlistVO.getGmno());
			pstmt.setString(2, gmlistVO.getShopno());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(String gmno, String shopno) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, gmno);
			pstmt.setString(2, shopno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public List<GmlistVO> findByGame(String gmno) {
		List<GmlistVO> list = new ArrayList<GmlistVO>();
		GmlistVO gmlistVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_GMLIST_BY_GAME);
			
			pstmt.setString(1, gmno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gmlistVO = new GmlistVO();
				gmlistVO.setGmno(rs.getString("gmno"));
				gmlistVO.setShopno(rs.getString("shopno"));
				list.add(gmlistVO);
			}
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
			
		return list;		
	}

	@Override
	public List<GmlistVO> findByShop(String shopno) {
		
		List<GmlistVO> list = new ArrayList<GmlistVO>();
		GmlistVO gmlistVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_GMLIST_BY_SHOP);
			
			pstmt.setString(1, shopno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gmlistVO = new GmlistVO();
				gmlistVO.setGmno(rs.getString("gmno"));
				gmlistVO.setShopno(rs.getString("shopno"));
				list.add(gmlistVO);
			}
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
			
		return list;		
	}
	
	public static void main(String[] args) {
		GmlistJDBCDAO dao = new GmlistJDBCDAO();
		
		// 新增
//		GmlistVO gmlistVO1 = new GmlistVO();
//		gmlistVO1.setGmno("DG00003");
//		gmlistVO1.setShopno("DS00001");
//		dao.insert(gmlistVO1);
	
		// 刪除
		dao.delete("DG00001", "DS00001");	
		
		//查詢有哪些店家有這款桌遊
		List<GmlistVO> list = dao.findByGame("DG00001");
		for (GmlistVO gmlist : list) {
			System.out.print(gmlist.getGmno() + ",");
			System.out.print(gmlist.getShopno());
			System.out.println();
		}
		//查詢店家有什麼桌遊
		List<GmlistVO> list2 = dao.findByShop("DS00001");
		for (GmlistVO gmlist : list2) {
			System.out.print(gmlist.getGmno() + ",");
			System.out.print(gmlist.getShopno());
			System.out.println();
		}
		
	}

}
