package com.shoprpdt.model;

import java.util.List;

import com.shoprpdt.model.ShoprpdtVO;

public class ShoprpdtService {
	
	ShoprpdtDAO_interface dao;
	
	public ShoprpdtService() {
		dao = new ShoprpdtJDBCDAO();
	}
	public ShoprpdtVO addShoprpdt(String shoprpno, String rmno, String mbrno, String shopno, String detail, Integer status) {
		
		ShoprpdtVO shoprpdtVO = new ShoprpdtVO();
		
		shoprpdtVO.setShoprpno(shoprpno);
		shoprpdtVO.setRmno(rmno);
		shoprpdtVO.setMbrno(mbrno);
		shoprpdtVO.setShopno(shopno);
		shoprpdtVO.setDetail(detail);
		shoprpdtVO.setStatus(status);
		dao.insert(shoprpdtVO);
		
		return shoprpdtVO;
	}
	public ShoprpdtVO updateShoprpdt(String shoprpno, String rmno, String mbrno, String shopno, String detail, Integer status) {
		
		ShoprpdtVO shoprpdtVO = new ShoprpdtVO();
		
		shoprpdtVO.setShoprpno(shoprpno);
		shoprpdtVO.setRmno(rmno);
		shoprpdtVO.setMbrno(mbrno);
		shoprpdtVO.setShopno(shopno);
		shoprpdtVO.setDetail(detail);
		shoprpdtVO.setStatus(status);
		dao.update(shoprpdtVO);
		
		return shoprpdtVO;
	}
	public List<ShoprpdtVO> getOneEmp(String shoprpno, Integer status) {
		return dao.findByPrimaryKey(shoprpno, status);
	}
	public List<ShoprpdtVO> getAll(){
		return dao.getAll();
	}
}
