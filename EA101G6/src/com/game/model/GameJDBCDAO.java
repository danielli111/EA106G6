package com.game.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.game.model.GameDAO_interface;

public class GameJDBCDAO implements GameDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BOARD_GAME";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO game (gmno, gmname) VALUES ('DG'||LPAD(TO_CHAR(GAME_seq.NEXTVAL), 5, '0'), ?)";
	private static final String UPDATE = 
			"UPDATE game set gmname = ? where gmno = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM game order by gmno";
	private static final String GET_ONE_STMT = 
			"SELECT gmno, gmname FROM game where gmname LIKE ?";
		
	

	@Override
	public void insert(GameVO gameVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, gameVO.getGmname());
			
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
	public void update(GameVO gameVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, gameVO.getGmname());
			pstmt.setString(2, gameVO.getGmno());
			
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
	public List<GameVO> findByGmname(String gmname) {
		List<GameVO> list = new ArrayList<GameVO>();
		GameVO gameVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, "%"+gmname+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				gameVO = new GameVO();
				gameVO.setGmno(rs.getString("gmno"));
				gameVO.setGmname(rs.getString("gmname"));
				list.add(gameVO);
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
	public List<GameVO> getAll() {
		List<GameVO> list = new ArrayList<GameVO>();
		GameVO gameVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);		
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				gameVO = new GameVO();
				gameVO.setGmno(rs.getString("gmno"));
				gameVO.setGmname(rs.getString("gmname"));
				list.add(gameVO);
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
		GameJDBCDAO dao = new GameJDBCDAO();

		// 新增
//		GameVO gameVO1 = new GameVO();
//		gameVO1.setGmname("欸欸");
//		dao.insert(gameVO1);

//		// 修改
//		GameVO gameVO2 = new GameVO();
//		gameVO2.setGmno("DG00001");
//		gameVO2.setGmname("阿瓦隆");
//		dao.update(gameVO2);


		// 查詢
		List<GameVO> list = dao.findByGmname("人");
		for (GameVO game : list) {
		System.out.print(game.getGmno() + ",");
		System.out.print(game.getGmname() + ",");
		System.out.println("---------------------");
		}

		// 查詢
//		List<GameVO> list2 = dao.getAll();
//		for (GameVO game : list2) {
//			System.out.print(game.getGmno() + ",");
//			System.out.print(game.getGmname());
//			System.out.println("---------------------");
//		}
	}
}
