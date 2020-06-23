package com.shoprpdt.controller;

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

import com.shoprpdt.model.*;


@MultipartConfig
public class ShoprpdtServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		
		if ("getSome_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String shoprpno = null;
				Integer status = null;
				if(req.getParameter("status") == null) {
					shoprpno = req.getParameter("shoprpno");
					status = 4;
				}
					
				if(req.getParameter("shoprpno") == null) {
					status = new Integer(req.getParameter("status"));
					shoprpno = "AA";
				}
					
				

				/*************************** 2.�}�l�d�߸�� *****************************************/
				ShoprpdtService shoprpdtSvc = new ShoprpdtService();
				List<ShoprpdtVO> shoprpdtVO = shoprpdtSvc.getSomeShoprpdt(shoprpno, status);
				if (shoprpdtVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("listAllShoprpdt.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
//				req.setAttribute("shoprpdtVO", shoprpdtVO); // ��Ʈw���X��shopVO����,�s�Jreq
				String url = "listSomeShoprpdt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("有錯誤:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShoprpdt.jsp");
				failureView.forward(req, res);
			}
		}
//		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllshop.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/*************************** 1.�����ШD�Ѽ� ****************************************/
//				String shoprpdtno = req.getParameter("shoprpdtno");
//
//				/*************************** 2.�}�l�d�߸�� ****************************************/
//				ShoprpdtService shoprpdtSvc = new ShoprpdtService();
//				ShoprpdtVO shoprpdtVO = shoprpdtSvc.getOneShoprpdt(shoprpdtno);
//
//				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
//				req.setAttribute("shoprpdtVO", shoprpdtVO); // ��Ʈw���X��shopVO����,�s�Jreq
//				String url = "update_shoprpdt_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_shop_input.jsp
//				successView.forward(req, res);
//
//				/*************************** ��L�i�઺���~�B�z **********************************/
//			} catch (Exception e) {
//				errorMsgs.add("有錯誤:" + e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("listAllShoprpdt.jsp");
//				failureView.forward(req, res);
//			}
//		}
//
		if ("update".equals(action)) { // �Ӧ�update_shop_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String shoprpno = req.getParameter("shoprpno");
				String rmno = req.getParameter("rmno");
				String mbrno = req.getParameter("mbrno");
				String shopno = req.getParameter("shopno");
				String detail = req.getParameter("detail");
				Integer status = new Integer(req.getParameter("status"));
				
				
				ShoprpdtVO shoprpdtVO = new ShoprpdtVO();
				shoprpdtVO.setShoprpno(shoprpno);
				shoprpdtVO.setRmno(rmno);
				shoprpdtVO.setMbrno(mbrno);
				shoprpdtVO.setShopno(shopno);
				shoprpdtVO.setDetail(detail);
				shoprpdtVO.setStatus(status);
				


				/*************************** 2.�}�l�ק��� *****************************************/
				ShoprpdtService shoprpdtSvc = new ShoprpdtService();
				shoprpdtVO = shoprpdtSvc.updateShoprpdt(shoprpno, rmno, mbrno, shopno, detail, status);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("shoprpdtVO", shoprpdtVO); // ��Ʈwupdate���\��,���T����shopVO����,�s�Jreq
				String url = "listAllShoprpdt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllShoprpdt.jsp");
				failureView.forward(req, res);
			}
		}
//
//		if ("insert".equals(action)) { // �Ӧ�addshop.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
////			try {
//				/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
//
//				String shopno = req.getParameter("shopno");
//				Integer ofdtable = new Integer(req.getParameter("ofdtable").trim());
//				String shoppds = req.getParameter("shoppds");
//				String shoppde = req.getParameter("shoppde");
//				Integer payinfohr = new Integer(req.getParameter("payinfohr").trim());				
//				Integer payinfoday = new Integer(req.getParameter("payinfoday").trim());
//				
//				ShoprpdtVO shoprpdtVO = new ShoprpdtVO();
//				shoprpdtVO.setShopno(shopno);
//				shoprpdtVO.setOfdtable(ofdtable);
//				shoprpdtVO.setShoppds(shoppds);
//				shoprpdtVO.setShoppde(shoppde);
//				shoprpdtVO.setPayinfohr(payinfohr);
//				shoprpdtVO.setPayinfoday(payinfoday);
//				
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("shoprpdtVO", shoprpdtVO); // �t����J�榡���~��shopVO����,�]�s�Jreq
//					RequestDispatcher failureView = req.getRequestDispatcher("addShoprpdt.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//
//				/*************************** 2.�}�l�s�W��� ***************************************/
//				ShoprpdtService shoprpdtSvc = new ShoprpdtService();
//				shoprpdtVO = shoprpdtSvc.addShoprpdt(shopno, ofdtable, shoppds, shoppde, payinfohr, payinfoday);
//
//				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
//				String url = "listAllShoprpdt.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllshop.jsp
//				successView.forward(req, res);
//
//				/*************************** ��L�i�઺���~�B�z **********************************/
////			} catch (Exception e) {
////				errorMsgs.add(e.getMessage());
////				RequestDispatcher failureView = req.getRequestDispatcher("addshoprpdt.jsp");
////				failureView.forward(req, res);
////			}
//		}
	
	}

}
	
