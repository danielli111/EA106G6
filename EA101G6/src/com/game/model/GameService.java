package com.game.model;

import java.util.List;

public class GameService {
	
	GameDAO_interface dao;
	
	public GameService() {
		dao = new GameJDBCDAO();
	}
	public GameVO addGame(String gmno, String gmname) {
		GameVO gameVO = new GameVO();
		return gameVO;
	}
	public GameVO updateGame(String gmno, String gmname) {
		GameVO gameVO = new GameVO();
		return gameVO;
	}
	public List<GameVO> getOneGame(String gmname) {
		return dao.findByGmname(gmname);
	}
	public List<GameVO> getAll() {
		return dao.getAll();
	}
}
