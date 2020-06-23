package com.shopbk.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopbk.model.*;


@MultipartConfig
public class ShopbkServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String shopbkno = req.getParameter("shopbkno");
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				ShopbkService shopbkSvc = new ShopbkService();
				ShopbkVO shopbkVO = shopbkSvc.getOneShopbk(shopbkno);
				if (shopbkVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("shopbkVO", shopbkVO); // ��Ʈw���X��shopVO����,�s�Jreq
				String url = "listOneshopbk.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("輸入有錯:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
				failureView.forward(req, res);
			}
		}
		if ("getSome_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String shoppds = null;
				String shoppde = null;
				if(req.getParameter("shopno")==null) {
					shoppds = req.getParameter("shoppds");
					shoppde = req.getParameter("shoppde");
				}
				if(req.getParameter("shopps")==null || req.getParameter("shoppe")==null) {
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				ShopbkService shopbkSvc = new ShopbkService();
				List<ShopbkVO> shopbkVO = shopbkSvc.getShopbkByTime(shoppds, shoppde);
				if (shopbkVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("shopbkVO", shopbkVO); // ��Ʈw���X��shopVO����,�s�Jreq
				String url = "listSomeShopbk.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("有錯誤:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
				failureView.forward(req, res);
			}
		}
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllshop.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String shopbkno = req.getParameter("shopbkno");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				ShopbkService shopbkSvc = new ShopbkService();
				ShopbkVO shopbkVO = shopbkSvc.getOneShopbk(shopbkno);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("shopbkVO", shopbkVO); // ��Ʈw���X��shopVO����,�s�Jreq
				String url = "update_shopbk_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_shop_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("有錯誤:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShopbk.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // �Ӧ�update_shop_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String shopbkno = req.getParameter("shopbkno");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				String shopno = req.getParameter("shopno");
				Integer ofdtable = new Integer(req.getParameter("ofdtable"));
				String shoppds = req.getParameter("shoppds");
				String shoppde = req.getParameter("shoppde");
				Integer payinfohr = new Integer(req.getParameter("payinfohr"));
				Integer payinfoday = new Integer(req.getParameter("payinfoday"));
				
				ShopbkVO shopbkVO = new ShopbkVO();
				shopbkVO.setShopbkno(shopbkno);
				shopbkVO.setShopno(shopno);
				shopbkVO.setOfdtable(ofdtable);
				shopbkVO.setShoppds(shoppds);
				shopbkVO.setShoppde(shoppde);
				shopbkVO.setPayinfohr(payinfohr);
				shopbkVO.setPayinfoday(payinfoday);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("shopbkVO", shopbkVO); // �t����J�榡���~��shopVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("update_shopbk_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				ShopbkService shopbkSvc = new ShopbkService();
				shopbkVO = shopbkSvc.updateShopbk(shopbkno, shopno, ofdtable, shoppds, shoppde, payinfohr, payinfoday);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("shopbkVO", shopbkVO); // ��Ʈwupdate���\��,���T����shopVO����,�s�Jreq
				String url = "listOneShopbk.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("update_shopbk_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // �Ӧ�addshop.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
//			try {
				/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/

				String shopno = req.getParameter("shopno");
				Integer ofdtable = new Integer(req.getParameter("ofdtable").trim());
				String shoppds = req.getParameter("shoppds");
				String shoppde = req.getParameter("shoppde");
				Integer payinfohr = new Integer(req.getParameter("payinfohr").trim());				
				Integer payinfoday = new Integer(req.getParameter("payinfoday").trim());
				
				ShopbkVO shopbkVO = new ShopbkVO();
				shopbkVO.setShopno(shopno);
				shopbkVO.setOfdtable(ofdtable);
				shopbkVO.setShoppds(shoppds);
				shopbkVO.setShoppde(shoppde);
				shopbkVO.setPayinfohr(payinfohr);
				shopbkVO.setPayinfoday(payinfoday);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("shopbkVO", shopbkVO); // �t����J�榡���~��shopVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("addShopbk.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.�}�l�s�W��� ***************************************/
				ShopbkService shopbkSvc = new ShopbkService();
				shopbkVO = shopbkSvc.addShopbk(shopno, ofdtable, shoppds, shoppde, payinfohr, payinfoday);

				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
				String url = "listAllShopbk.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("addshopbk.jsp");
//				failureView.forward(req, res);
//			}
		}
	
	}

}
	
