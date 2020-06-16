package com.shopbk.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.shopbk.model.ShopbkVO;

public class ShopbkService {
	
	ShopbkDAO_interface dao;
	
	public ShopbkService() {
		dao = new ShopbkJDBCDAO();
	}
	public ShopbkVO addShopbk(String shopbkno, String shopno, Integer ofdtable, String shoppds, String shoppde, Integer payinfohr, Integer payinfoday) {
		
		ShopbkVO shopbkVO = new ShopbkVO();
		
		shopbkVO.setShopbkno(shopbkno);
		shopbkVO.setShopno(shopno);
		shopbkVO.setOfdtable(ofdtable);
		shopbkVO.setShoppds(shoppds);
		shopbkVO.setShoppde(shoppde);
		shopbkVO.setPayinfohr(payinfohr);
		shopbkVO.setPayinfoday(payinfoday);
		dao.insert(shopbkVO);
		
		return shopbkVO;
		
	}
	public ShopbkVO updateShopbk(String shopbkno, String shopno, Integer ofdtable, String shoppds, String shoppde, Integer payinfohr, Integer payinfoday) {
		
		ShopbkVO shopbkVO = new ShopbkVO();
		
		shopbkVO.setShopbkno(shopbkno);
		shopbkVO.setShopno(shopno);
		shopbkVO.setOfdtable(ofdtable);
		shopbkVO.setShoppds(shoppds);
		shopbkVO.setShoppde(shoppde);
		shopbkVO.setPayinfohr(payinfohr);
		shopbkVO.setPayinfoday(payinfoday);
		dao.update(shopbkVO);
		
		return shopbkVO;
		
	}
	public List<ShopbkVO> getOneShop(String Shopbkno, String shoppd) {
		return dao.findByPrimaryKey(Shopbkno, shoppd);
	}
	public List<ShopbkVO> getAll() {
		return dao.getAll();
	}
}
