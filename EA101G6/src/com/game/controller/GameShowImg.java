package com.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.model.*;

@WebServlet("/GameShowImg")
public class GameShowImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream out=res.getOutputStream();
		
            res.setContentType("image/jpeg");
            String gmno=req.getParameter("gmno");
//            String account=req.getParameter("shopact");
            HttpSession session = req.getSession();
            GameService gameSvc = new GameService();
            GameVO gameVo=null;
            /*用session判斷是否從update進來*/
            if(session.getAttribute(gmno)!=null) {
            	gameVo=(GameVO)session.getAttribute(gmno);
            }else{
            	gameVo=gameSvc.getOneGame(gmno);
            	session.setAttribute(gmno,gameVo);
            }
            out.write(gameVo.getGmimg());
            
		
	}

}
