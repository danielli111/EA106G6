package com.shop.controller;

import java.io.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.shop.model.*;

@MultipartConfig
public class ShopServlet extends HttpServlet {
	String saveDirectory = "/images_uploaded";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String shopno = req.getParameter("shopno");
				String shopnoReg = "[D][S]\\d{5}";
				if (shopno == null || (shopno.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				} else if (!shopno.trim().matches(shopnoReg)) {
					errorMsgs.add("員工編號不符合格式");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				ShopService shopSvc = new ShopService();
				ShopVO shopVO = shopSvc.getOneShop(shopno);
				if (shopVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("shopVO", shopVO); // 資料庫取出的shopVO物件,存入req
				String url = "listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneshop.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
				failureView.forward(req, res);
			}
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllshop.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			ShopService shopSvc = new ShopService();
			String shopno = null;
			ShopVO shopVO = null;
			shopVO = (ShopVO) session.getAttribute("account");
			try {
				/*************************** 1.接收請求參數 ****************************************/
				if(req.getParameter("shopno") == null) {
					shopno = shopVO.getShopno();					
				}
				else{
					shopno = req.getParameter("shopno");
				}
				
				

				/*************************** 2.開始查詢資料 ****************************************/
//				ShopService shopSvc = new ShopService();
				shopVO = shopSvc.getOneShop(shopno);
				

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("shopVO", shopVO); // 資料庫取出的shopVO物件,存入req
				String url = "update_shop_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_shop_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_shop_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String shopno = req.getParameter("shopno");
				String shopnoReg = "[D][S]\\d{5}";
				if (shopno == null || (shopno.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				} else if (!shopno.trim().matches(shopnoReg)) {
					errorMsgs.add("員工編號不符合格式");
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String shopname = req.getParameter("shopname");
				String shopnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,10}$";
				if (shopname == null || shopname.trim().length() == 0) {
					errorMsgs.add("店家名稱: 請勿空白");
				} else if (!shopname.trim().matches(shopnameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String shopact = req.getParameter("shopact");
				String shopactReg = "^[(a-zA-Z0-9)]{3,10}$";
				if (shopact == null || shopact.trim().length() == 0) {
					errorMsgs.add("店家帳號: 請勿空白");
				} else if (!shopact.trim().matches(shopactReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家帳號: 只能是大小寫英文字母或數字 , 且長度必需在3到10之間");
				}

				String shoppw = req.getParameter("shoppw");
				String shoppwReg = "^[(a-zA-Z0-9)]{3,10}$";
				if (shoppw == null || shoppw.trim().length() == 0) {
					errorMsgs.add("店家密碼: 請勿空白");
				} else if (!shoppw.trim().matches(shoppwReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家密碼: 只能是大小寫英文字母或數字 , 且長度必需在3到10之間");
				}

				String shoploc = req.getParameter("shoploc");
				String shoplocReg = "^[(\\u4e00-\\u9fa5)]{3,9}$";
				if (shoploc == null || shoploc.trim().length() == 0) {
					errorMsgs.add("店家位置: 請勿空白");
				} else if (!shoploc.trim().matches(shoplocReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家位置: 只能是中文或數字 , 且長度必需在3到9之間");
				}

				String shopcy = req.getParameter("shopcy");
				String shopcyReg = "^[(\\u4e00-\\u9fa5)(0-9\\*)]{3,9}$";
				if (shopcy == null || shopcy.trim().length() == 0) {
					errorMsgs.add("店家場地: 請勿空白");
				} else if (!shopcy.trim().matches(shopcyReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家場地: 只能是中文、數字或* , 且長度必需在3到9之間");
				}
				Integer shopphone = null;
				try {
					shopphone = new Integer(req.getParameter("shopphone"));

				} catch (NumberFormatException e) {
					shopphone = 912345678;
					errorMsgs.add("電話請填數字");
				}
				byte[] shopimg = null;

				Part part;
				part = req.getPart("shopimg");

				InputStream in = null;

				try {
					 if(part.getSize() == 0) {			            	
			     		ShopService shopSvc = new ShopService();
		         		ShopVO shopVo=shopSvc.getOneShop(shopno);
		         		shopimg = shopVo.getShopimg(); 
		         		in = part.getInputStream();
		         		in.read(shopimg);
					 }else{
		            	in = part.getInputStream();
		            	shopimg = new byte[in.available()];
		          		in.read(shopimg);
			    	  } 
				}catch (IOException e) {
					errorMsgs.add("上傳失敗");
					in = getServletContext().getResourceAsStream("/NoData/null.jpg");
					shopimg = new byte[in.available()];
	          		in.read(shopimg);
				}finally {
					in.close();
				}

				Integer status = new Integer(req.getParameter("status").trim());

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

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("shopVO", shopVO); // 含有輸入格式錯誤的shopVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("update_shop_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				ShopService shopSvc = new ShopService();
				shopVO = shopSvc.updateShop(shopno, shopact, shoppw, shopname, shoploc, shopcy, shopphone, shopimg,
						status);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("shopVO", shopVO); // 資料庫update成功後,正確的的shopVO物件,存入req
				String url = "listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneshop.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("update_shop_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // 來自addshop.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

				String shopname = req.getParameter("shopname");
				String shopnameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,10}$";
				if (shopname == null || shopname.trim().length() == 0) {
					errorMsgs.add("店家名稱: 請勿空白");
				} else if (!shopname.trim().matches(shopnameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String shopact = req.getParameter("shopact");
				String shopactReg = "^[(a-zA-Z0-9)]{3,10}$";
				if (shopact == null || shopact.trim().length() == 0) {
					errorMsgs.add("店家帳號: 請勿空白");
				} else if (!shopact.trim().matches(shopactReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家帳號: 只能是大小寫英文字母或數字 , 且長度必需在3到10之間");
				}

				String shoppw = req.getParameter("shoppw");
				String shoppwReg = "^[(a-zA-Z0-9)]{3,10}$";
				if (shoppw == null || shoppw.trim().length() == 0) {
					errorMsgs.add("店家密碼: 請勿空白");
				} else if (!shoppw.trim().matches(shoppwReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家密碼: 只能是大小寫英文字母或數字 , 且長度必需在3到10之間");
				}

				String shoploc = req.getParameter("shoploc");
				String shoplocReg = "^[(\\u4e00-\\u9fa5)]{3,9}$";
				if (shoploc == null || shoploc.trim().length() == 0) {
					errorMsgs.add("店家位置: 請勿空白");
				} else if (!shoploc.trim().matches(shoplocReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家位置: 只能是中文或數字 , 且長度必需在3到9之間");
				}

				String shopcy = req.getParameter("shopcy");
				String shopcyReg = "^[(\\u4e00-\\u9fa5)(0-9\\*)]{3,9}$";
				if (shopcy == null || shopcy.trim().length() == 0) {
					errorMsgs.add("店家場地: 請勿空白");
				} else if (!shopcy.trim().matches(shopcyReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("店家場地: 只能是中文、數字或* , 且長度必需在3到9之間");
				}
				Integer shopphone = null;
				try {
					shopphone = new Integer(req.getParameter("shopphone"));

				} catch (NumberFormatException e) {
					shopphone = 912345678;
					errorMsgs.add("電話請填數字");
				}
				
				byte[] shopimg = null;
				Part part = req.getPart("shopimg");
				InputStream in = null;
				try {
					in = part.getInputStream();
					shopimg = new byte[in.available()];
					in.read(shopimg);
				} catch (IOException e) {

				} finally {
					in.close();
				}
				Integer status = new Integer(req.getParameter("status").trim());

				ShopVO shopVO = new ShopVO();
				shopVO.setShopact(shopact);
				shopVO.setShoppw(shoppw);
				shopVO.setShopname(shopname);
				shopVO.setShoploc(shoploc);
				shopVO.setShopcy(shopcy);
				shopVO.setShopphone(shopphone);
				shopVO.setShopimg(shopimg);
				shopVO.setStatus(status);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("shopVO", shopVO); // 含有輸入格式錯誤的shopVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("addShop.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				ShopService shopSvc = new ShopService();
				shopVO = shopSvc.addShop(shopact, shoppw, shopname, shoploc, shopcy, shopphone, shopimg, status);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "listAllShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllshop.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("addShop.jsp");
				failureView.forward(req, res);
			}
		}
		if ("login".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			
			ShopVO shopVO = new ShopVO();
			shopVO.setShopact(account);
			shopVO.setShoppw(password);
			
			ShopService shopSvc = new ShopService();
			shopVO = shopSvc.compare(account, password);
			if (shopVO == null) {
				errorMsgs.add("錯了啦");
			}			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shopVO", shopVO); // 含有輸入格式錯誤的shopVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			shopVO = shopSvc.getOneShop(shopVO.getShopno());
			session.setAttribute("account", shopVO);
			RequestDispatcher failureView = req.getRequestDispatcher("index.jsp");
			failureView.forward(req, res);
		}

	}

}
