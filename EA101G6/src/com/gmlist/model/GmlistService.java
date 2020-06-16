package com.gmlist.model;

import java.util.List;

public class GmlistService {

	GmlistDAO_interface dao;
	
	public GmlistService() {
		dao = new GmlistJDBCDAO();
	}
	public GmlistVO addGmlist(String gmno, String shopno) {
		
		GmlistVO gmlistVO = new GmlistVO();
		
		gmlistVO.setGmno(gmno);
		gmlistVO.setShopno(shopno);
		dao.insert(gmlistVO);
		
		return gmlistVO;
	}
	public void deleteGmlist(String gmno, String shopno) {
		dao.delete(gmno,shopno);
	}
	public List<GmlistVO> findByGame(String gmno) {
		return dao.findByGame(gmno);	
	}
	public List<GmlistVO> findByShop(String shopno) {
		return dao.findByGame(shopno);	
	}
}
