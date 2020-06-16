package com.shopbk.model;

import java.sql.Timestamp;
import java.util.List;

import com.shopbk.model.ShopbkVO;

public interface ShopbkDAO_interface {
	public void insert(ShopbkVO shopbkVO);
	public void update(ShopbkVO shopbkVO);
	public void delete(String shopbkno);
	public List<ShopbkVO> findByPrimaryKey(String shopbkno, String shoppd);
	public List<ShopbkVO> getAll();
}
