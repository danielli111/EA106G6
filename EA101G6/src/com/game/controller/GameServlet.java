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
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String gmno = req.getParameter("gmno");
				
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				GameService gameSvc = new GameService();
				GameVO gameVO = gameSvc.getOneGame(gmno);
				if (gameVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // 資料庫取出的shopVO物件,存入req
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
		if ("getSome_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String gmname = req.getParameter("gmname");
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				GameService gameSvc = new GameService();
				List<GameVO> gameVO = gameSvc.getSomeGames(gmname);
				if (gameVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
RequestDispatcher failureView = req.getRequestDispatcher("listAllShop.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // 資料庫取出的shopVO物件,存入req
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

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String gmno = req.getParameter("gmno");

				/*************************** 2.開始查詢資料 ****************************************/
				GameService gameSvc = new GameService();
				GameVO gameVO = gameSvc.getOneGame(gmno);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("gameVO", gameVO); // 資料庫取出的shopVO物件,存入req
				String url = "update_game_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_shop_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("listAllGame.jsp");
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
				String gmno = req.getParameter("gmno");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
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
					errorMsgs.add("上傳失敗");
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
					req.setAttribute("gameVO", gameVO); // 含有輸入格式錯誤的shopVO物件,也存入req
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/update_shop_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				GameService gameSvc = new GameService();
				gameVO = gameSvc.updateGame(gmno, gmname, gmimg);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("gameVO", gameVO); // 資料庫update成功後,正確的的shopVO物件,存入req
String url = "/font-end/shop/listOneShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneshop.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/update_shop_input.jsp");
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
					req.setAttribute("gameVO", gameVO); // 含有輸入格式錯誤的shopVO物件,也存入req
RequestDispatcher failureView = req.getRequestDispatcher("addShop.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				GameService gameSvc = new GameService();
				gameVO = gameSvc.addGame(gmname, gmimg);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
String url = "listAllShop.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllshop.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("/font-end/shop/addShop.jsp");
				failureView.forward(req, res);
			}
		}
	
	}

}
