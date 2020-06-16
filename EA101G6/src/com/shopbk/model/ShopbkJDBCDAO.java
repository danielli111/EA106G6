package com.shopbk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.shopbk.model.ShopbkDAO_interface;

public class ShopbkJDBCDAO implements ShopbkDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BOARD_GAME";
	String passwd = "123456";
	
	private static final String INSERT_STMT =
			"INSERT INTO SHOPBK (shopbkno, shopno, ofdtable, shoppds, shoppde, payinfohr, payinfoday) VALUES ('DB'||LPAD(TO_CHAR(SHOPBK_seq.NEXTVAL), 5, '0'), ?, ?, to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss'), to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss'), ?, ?)";
	private static final String UPDATE =
			"UPDATE SHOPBK set shopno=?, ofdtable=?, shoppds=to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss'), shoppde=to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss'), payinfohr=?, payinfoday=? WHERE SHOPBKNO = ?";
	private static final String GET_ALL_STMT =
			"SELECT shopbkno,shopno,ofdtable,shoppds,shoppde,payinfohr,payinfoday FROM SHOPBK ORDER BY SHOPBKNO";
	private static final String GET_SOME_STMT =
			"SELECT shopbkno,shopno,ofdtable,shoppds,shoppde,payinfohr,payinfoday FROM SHOPBK WHERE SHOPBKNO = ? or to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss') >= shoppds";
	private static final String DELETE =
			"DELETE FROM shopbk where shopbkno =?";
	@Override
	public void insert(ShopbkVO shopbkVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, shopbkVO.getShopno());
			pstmt.setInt(2, shopbkVO.getOfdtable());
			pstmt.setString(3, shopbkVO.getShoppds());
			pstmt.setString(4, shopbkVO.getShoppde());
			pstmt.setInt(5, shopbkVO.getPayinfohr());
			pstmt.setInt(6, shopbkVO.getPayinfoday());
			
			
			pstmt.executeUpdate();
			
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
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
	public void update(ShopbkVO shopbkVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, shopbkVO.getShopno());
			pstmt.setInt(2, shopbkVO.getOfdtable());
			pstmt.setString(3, shopbkVO.getShoppds());
			pstmt.setString(4, shopbkVO.getShoppde());
			pstmt.setInt(5, shopbkVO.getPayinfohr());
			pstmt.setInt(6, shopbkVO.getPayinfoday());
			pstmt.setString(7, shopbkVO.getShopbkno());
			
			pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
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
	public void delete(String shopbkno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, shopbkno);
			
			pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
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
	public List<ShopbkVO> findByPrimaryKey(String shopbkno, String shoppd) {
		List<ShopbkVO> list = new ArrayList<ShopbkVO>();
		ShopbkVO shopbkVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_SOME_STMT);
			
			pstmt.setString(1, shopbkno);
			pstmt.setString(2, shoppd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shopbkVO = new ShopbkVO();
				shopbkVO.setShopbkno(rs.getString("shopbkno"));
				shopbkVO.setShopno(rs.getString("shopno"));
				shopbkVO.setOfdtable(rs.getInt("ofdtable"));
				shopbkVO.setShoppds(rs.getString("shoppds"));
				shopbkVO.setShoppde(rs.getString("shoppde"));
				shopbkVO.setPayinfohr(rs.getInt("payinfohr"));
				shopbkVO.setPayinfoday(rs.getInt("payinfoday"));
				list.add(shopbkVO);				
			}
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}

	@Override
	public List<ShopbkVO> getAll() {
		List<ShopbkVO> list = new ArrayList<ShopbkVO>();
		ShopbkVO shopbkVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shopbkVO = new ShopbkVO();
				shopbkVO.setShopbkno(rs.getString("shopbkno"));
				shopbkVO.setShopno(rs.getString("shopno"));
				shopbkVO.setOfdtable(rs.getInt("ofdtable"));
				shopbkVO.setShoppds(rs.getString("shoppds"));
				shopbkVO.setShoppde(rs.getString("shoppde"));
				shopbkVO.setPayinfohr(rs.getInt("payinfohr"));
				shopbkVO.setPayinfoday(rs.getInt("payinfoday"));
				list.add(shopbkVO);				
			}
									
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}
	public static void main(String[] args) {
		ShopbkJDBCDAO dao = new ShopbkJDBCDAO();

		
		
		// 新增
//		ShopbkVO shopbkVO1 = new ShopbkVO();
//		shopbkVO1.setShopno("DS00003");
//		shopbkVO1.setOfdtable(30);
//		shopbkVO1.setShoppds("2020-07-01 12:00");
//		shopbkVO1.setShoppde("2020-07-01 20:00");
//		shopbkVO1.setPayinfohr(30);
//		shopbkVO1.setPayinfoday(130);
//		dao.insert(shopbkVO1);
		// 修改
//		ShopbkVO shopbkVO = new ShopbkVO();
//		shopbkVO.setShopbkno("DB00001");
//		shopbkVO.setShopno("DS00001");
//		shopbkVO.setOfdtable(30);
//		shopbkVO.setShoppds("2020-06-30 12:00");
//		shopbkVO.setShoppde("2020-06-30 20:00");
//		shopbkVO.setPayinfohr(50);
//		shopbkVO.setPayinfoday(150);
//		dao.update(shopbkVO);
		// 刪除
		dao.delete("DB00011");
		// 查詢
//		List<ShopbkVO> list = dao.findByPrimaryKey("DB00001", "2020-06-30 12:00");
//		for(ShopbkVO shopbk : list) {
//			System.out.println(shopbk.getShopbkno() + ",");
//			System.out.println(shopbk.getShopno() + ",");
//			System.out.println(shopbk.getOfdtable() + ",");
//			System.out.println(shopbk.getShoppds() + ",");
//			System.out.println(shopbk.getShoppde() + ",");
//			System.out.println(shopbk.getPayinfohr() + ",");
//			System.out.println(shopbk.getPayinfoday() + ",");
//			System.out.println();
//		}
		// 查詢
//		List<ShopbkVO> list2 = dao.getAll();
//		for(ShopbkVO shopbk : list2) {
//			System.out.println(shopbk.getShopbkno() + ",");
//			System.out.println(shopbk.getShopno() + ",");
//			System.out.println(shopbk.getOfdtable() + ",");
//			System.out.println(shopbk.getShoppds() + ",");
//			System.out.println(shopbk.getShoppde() + ",");
//			System.out.println(shopbk.getPayinfohr() + ",");
//			System.out.println(shopbk.getPayinfoday() + ",");
//			System.out.println();
//		}
	}
}
