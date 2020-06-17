package com.game.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shop.model.ShopService;
import com.shop.model.ShopVO;
import com.game.model.*;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
       
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
				String gmno = req.getParameter("gmno");
				
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				GameService gameSvc = new GameService();
				GameVO gameVO = gameSvc.getOneGame(gmno);
				if (gameVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // ��Ʈw���X��shopVO����,�s�Jreq
String url = "listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
				failureView.forward(req, res);
			}
		}
		if ("getSome_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String gmname = req.getParameter("gmname");
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				GameService gameSvc = new GameService();
				List<GameVO> gameVO = gameSvc.getSomeGames(gmname);
				if (gameVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // ��Ʈw���X��shopVO����,�s�Jreq
String url = "listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
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
				String gmno = req.getParameter("gmno");

				/*************************** 2.�}�l�d�߸�� ****************************************/
				GameService gameSvc = new GameService();
				GameVO gameVO = gameSvc.getOneGame(gmno);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("gameVO", gameVO); // ��Ʈw���X��shopVO����,�s�Jreq
				String url = "update_game_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_shop_input.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllGame.jsp");
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
				String gmno = req.getParameter("gmno");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				String gmname = req.getParameter("gmname");
				GameVO vo = (GameVO) session.getAttribute(gmno);
				byte[] gmimg = null;

				Part part;
				part = req.getPart("gmimg");

				InputStream in = null;
				try {
					in = part.getInputStream();
					if (part.getSize() != 0) {
						gmimg = new byte[in.available()];				
					}else {
						gmimg = vo.getGmimg();
					}
					in.read(gmimg);
					
					
				} catch (IOException e) {
					errorMsgs.add("�W�ǥ���");
				} finally {
					in.close();
				}


				GameVO gameVO = new GameVO();
				gameVO.setGmno(gmno);
				gameVO.setGmname(gmname);
				gameVO.setGmimg(gmimg);
				

				session.removeAttribute(gmno);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("gameVO", gameVO); // �t����J�榡���~��shopVO����,�]�s�Jreq
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/update_shop_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				GameService gameSvc = new GameService();
				gameVO = gameSvc.updateGame(gmno, gmname, gmimg);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // ��Ʈwupdate���\��,���T����shopVO����,�s�Jreq
String url = "/font-end/shop/listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/update_shop_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // �Ӧ�addshop.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/

				String gmname = req.getParameter("gmname");
				byte[] gmimg = null;
				Part part = req.getPart("gmimg");
				InputStream in = null;
				try {
					in = part.getInputStream();
					gmimg = new byte[in.available()];
					in.read(gmimg);
				} catch (IOException e) {
					e.getMessage();
				} finally {
					in.close();
				}

				GameVO gameVO = new GameVO();
				gameVO.setGmname(gmname);
				gameVO.setGmimg(gmimg);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("gameVO", gameVO); // �t����J�榡���~��shopVO����,�]�s�Jreq
RequestDispatcher failureView = req.getRequestDispatcher("addShop.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.�}�l�s�W��� ***************************************/
				GameService gameSvc = new GameService();
				gameVO = gameSvc.addGame(gmname, gmimg);

				/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
String url = "listAllShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllshop.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/addShop.jsp");
				failureView.forward(req, res);
			}
		}
	
	}

}
