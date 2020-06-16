package com.shop.model;

import java.util.List;


public class ShopService {
	
	  ShopDAO_interface dao;
	
	public ShopService() {
		dao = new ShopJDBCDAO();
	}
	public ShopVO addShop(String shopact, String shoppw, String shopname, String shoploc, String shopcy, Integer shopphone, byte[] shopimg,Integer status) {
		
		ShopVO shopVO = new ShopVO();
		
		shopVO.setShopact(shopact);
		shopVO.setShoppw(shoppw);
		shopVO.setShopname(shopname);
		shopVO.setShoploc(shoploc);
		shopVO.setShopcy(shopcy);
		shopVO.setShopphone(shopphone);
		shopVO.setShopimg(shopimg);
		shopVO.setStatus(status);
		dao.insert(shopVO);
		
		return shopVO;
		
	}
	
	public ShopVO updateShop(String shopno, String shopact, String shoppw, String shopname, String shoploc, String shopcy, Integer shopphone, byte[] shopimg, Integer status) {

		ShopVO shopVO = new ShopVO();

		shopVO.setShopno(shopno);
		shopVO.setShopact(shopact);
		shopVO.setShoppw(shoppw);
		shopVO.setShopname(shopname);
		shopVO.setShoploc(shoploc);
		shopVO.setShopcy(shopcy);
		shopVO.setShopphone(shopphone);
		shopVO.setShopimg(shopimg);
		shopVO.setStatus(status);
		dao.update(shopVO);
		
		return shopVO;
	}
	
	public ShopVO getOneShop(String Shopno) {
		return dao.findByPrimaryKey(Shopno);
	}
	
	public List<ShopVO> getAll() {
		return dao.getAll();
	}
}
