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
			"INSERT INTO GAME (GMNO, GMNAME,GMIMG) VALUES ('DG'||LPAD(TO_CHAR(GAME_SEQ.NEXTVAL), 5, '0'), ?, ?)";
	private static final String UPDATE = 
			"UPDATE GAME SET GMNAME = ?, GMIMG = ? WHERE GMNO = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM GAME ORDER BY GMNO";
	private static final String GET_SOME_STMT = 
			"SELECT GMNO, GMNAME, GMIMG FROM GAME WHERE GMNAME LIKE ?";
	private static final String GET_ONE_STMT = 
			"SELECT GMNO, GMNAME, GMIMG FROM GAME WHERE GMNO = ?";
	

	@Override
	public void insert(GameVO gameVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, gameVO.getGmname());
			pstmt.setBytes(2, gameVO.getGmimg());
			
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
			pstmt.setBytes(2, gameVO.getGmimg());
			pstmt.setString(3, gameVO.getGmno());
			
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
	public List<GameVO> findByGmnames(String gmname) {
		List<GameVO> list = new ArrayList<GameVO>();
		GameVO gameVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_SOME_STMT);
			
			pstmt.setString(1, "%"+gmname+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				gameVO = new GameVO();
				gameVO.setGmno(rs.getString("gmno"));
				gameVO.setGmname(rs.getString("gmname"));
				gameVO.setGmimg(rs.getBytes("gmimg"));
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
				gameVO.setGmimg(rs.getBytes("gmimg"));
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
	public GameVO findByPrimaryKey(String gmno) {
		GameVO gameVO = null;	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, gmno);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				gameVO = new GameVO();
				gameVO.setGmno(rs.getString("gmno"));
				gameVO.setGmname(rs.getString("gmname"));
				gameVO.setGmimg(rs.getBytes("gmimg"));
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
		return gameVO;
	}
	
	public static void main(String[] args) {
		GameJDBCDAO dao = new GameJDBCDAO();
		GameService gameSvc = new GameService();
		// �s�W
		GameVO gameVO1 = new GameVO();
		gameVO1.setGmname("����");
		gameVO1.setGmimg(null);
		gameSvc.addGame("安安安", null);
		System.out.println("fdfasd");
//		// �ק�
//		GameVO gameVO2 = new GameVO();
//		gameVO2.setGmno("DG00001");
//		gameVO2.setGmname("���˶�");
//		dao.update(gameVO2);


		// �d��
//		List<GameVO> list = dao.findByGmnames("�H");
//		for (GameVO game : list) {
//		System.out.print(game.getGmno() + ",");
//		System.out.print(game.getGmname() + ",");
//		System.out.println("---------------------");
//		}

		// �d��
//		List<GameVO> list2 = dao.getAll();
//		for (GameVO game : list2) {
//			System.out.print(game.getGmno() + ",");
//			System.out.print(game.getGmname());
//			System.out.println("---------------------");
//		}
		
//		GameVO gameVo = gameSvc.getOneGame("DG00001");
//		System.out.print(gameVo.getGmno() + ",");
//		System.out.print(gameVo.getGmname() + ",");
//		System.out.println("---------------------");
		
	}

	
}
