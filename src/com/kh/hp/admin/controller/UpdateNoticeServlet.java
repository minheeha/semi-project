package com.kh.hp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.NoticeService;
import com.kh.hp.admin.model.service.UpdateOneUserService;
import com.kh.hp.admin.model.vo.NoticeVO;
import com.kh.hp.admin.model.vo.UpdateUserVO;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/updateNotice.ad")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateNoticeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("공지사항 업데이트서블릿입니다 ");

		int noticeSeq = Integer.parseInt(request.getParameter("noticeSeq"));
		String noticeCate  =request.getParameter("noticeCate");
		String noticeTitile = request.getParameter("noticeTitle");
		String noticeContent =request.getParameter("noticeContent");

	

		NoticeVO updateNotice = new NoticeVO ();


		updateNotice.setNoticeSeq(noticeSeq);
		updateNotice.setNoticeCate(noticeCate);
		updateNotice.setNoticeTitile(noticeTitile);
		updateNotice.setNoticeContent(noticeContent);
		
		int result = new NoticeService().updateNotice(updateNotice);
		
		String page = "";

	if(result > 0) {
			
			request.getRequestDispatcher("/SelectNotice").forward(request, response);
		
		}else {
		
			page = "views/main/main.jsp";

		}
	}






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
