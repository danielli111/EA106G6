package com.game.model;

import java.util.List;

public class GameService {
	
	GameDAO_interface dao;
	
	public GameService() {
		dao = new GameJDBCDAO();
	}
	public GameVO addGame(String gmname, byte[] gmimg) {
		GameVO gameVO = new GameVO();
		
		gameVO.setGmname(gmname);
		gameVO.setGmimg(gmimg);
		dao.insert(gameVO);
		
		return gameVO;
	}
	public GameVO updateGame(String gmno, String gmname, byte[] gmimg) {
		GameVO gameVO = new GameVO();
		
		gameVO.setGmno(gmno);
		gameVO.setGmname(gmname);
		gameVO.setGmimg(gmimg);	
		dao.update(gameVO);
		
		return gameVO;
	}
	public List<GameVO> getSomeGames(String gmname) {
		return dao.findByGmnames(gmname);
	}
	public List<GameVO> getAll() {
		return dao.getAll();
	}
	public GameVO getOneGame(String gmno) {
		return dao.findByPrimaryKey(gmno);
	}
}
