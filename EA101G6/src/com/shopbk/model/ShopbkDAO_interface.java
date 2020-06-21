package com.shopbk.model;

import java.util.List;

import com.shopbk.model.ShopbkVO;

public interface ShopbkDAO_interface {
	public void insert(ShopbkVO shopbkVO);
	public void update(ShopbkVO shopbkVO);
	public void delete(String shopbkno);
	public ShopbkVO findByPrimaryKey(String shopbkno);
	public List<ShopbkVO> findByShoppd(String shoppds, String shoppde);
	public List<ShopbkVO> findByShop(String shopno);
	public List<ShopbkVO> getAll();
}
