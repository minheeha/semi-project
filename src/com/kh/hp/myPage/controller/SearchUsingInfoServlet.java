package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import com.kh.hp.myPage.model.vo.PageInfo;

/**
 * Servlet implementation class SearchUsingInfoServlet
 */
@WebServlet("/searchUsingInfo")
public class SearchUsingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUsingInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("왜 사용내역 서치가 안될까..");
		int userInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		String rentSeq = request.getParameter("rentSeq");
		//int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));
		String hallNm = request.getParameter("hallNm");
		String useDt = request.getParameter("cusClosedate");
		Date useStart = null;
		Date useEnd = null;
		int rentSeq2 = 0;
		
		if(rentSeq != null && !rentSeq.equals("")) {
			rentSeq2 = Integer.parseInt(request.getParameter("rentSeq"));
		}
		
		System.out.println("rentSeq2 : " + rentSeq2);
		
		/*캘린더 설정*/
		if(useDt != null && !useDt.equals("")) {
			String[] temp = useDt.split(" to ");
			useStart = Date.valueOf(temp[0]);
			useEnd = Date.valueOf(temp[1]);
		}
		
		System.out.println("useStart : " + useStart);
		System.out.println("useEnd : " + useEnd);
		System.out.println("hallNm : " + hallNm);
		System.out.println("rentSeq2 : " + rentSeq2);
		
		int currentPage;		//현재 페이지를 표시할 변수
		int limit;				//한 페이지에 보여질 게시물 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
		int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		
		int listCount = new AhnMyPageService().getListCount3(userInfo);
		
		System.out.println("listCount : " + listCount);
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageService().searchCheck( userInfo, rentSeq2, hallNm, useStart, useEnd, startPage, endPage);
		
		String page = "";
		
		if(list != null) {
			page = "views/myPage/searchUsingInfo.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "검색내역 조회 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
