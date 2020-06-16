package com.shop.model;

import java.util.*;

import com.shop.model.ShopVO;

public interface ShopDAO_interface {
	public void insert(ShopVO shopVO);
	public void update(ShopVO shopVO);
	public ShopVO findByPrimaryKey(String shoppno);
	public List<ShopVO> getAll();
}
