package com.game.model;
import java.util.List;

import com.game.model.GameVO;
public interface GameDAO_interface {
	public void insert(GameVO gameVO);
	public void update(GameVO gameVO);
	public List<GameVO> findByGmnames(String gmname);
	public GameVO findByPrimaryKey(String gmno);
	public List<GameVO> getAll();
}
