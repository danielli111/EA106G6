package com.game.model;
import java.util.List;

import com.game.model.GameVO;
public interface GameDAO_interface {
	public void insert(GameVO gameVO);
	public void update(GameVO gameVO);
	public List<GameVO> findByGmname(String gmname);
	public List<GameVO> getAll();
}
