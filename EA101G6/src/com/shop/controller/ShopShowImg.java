package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.ShopService;
import com.shop.model.ShopVO;

@WebServlet("/ShopShowImg")
public class ShopShowImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream out=res.getOutputStream();
		
            res.setContentType("image/jpeg");
            String shopno=req.getParameter("shopno");
            HttpSession session = req.getSession();
            ShopService shopSvc = new ShopService();
            ShopVO shopVo=null;
            /*��session�P�_�O�_�qupdate�i��*/
            if(session.getAttribute(shopno)==null) {
            	shopVo=shopSvc.getOneShop(shopno);
            	session.setAttribute(shopno,shopVo);
            }else{
            	shopVo=(ShopVO)session.getAttribute(shopno);
            }
            out.write(shopVo.getShopimg());
            
		
	}

}