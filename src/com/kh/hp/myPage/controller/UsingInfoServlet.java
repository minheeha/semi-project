package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;

/**
 * Servlet implementation class UsingInfoServlet
 */
@WebServlet("/usingInfo")
public class UsingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsingInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*int usingInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageService().searchCheck(usingInfo);
		
		System.out.println("controller list : " + list);
		
		String page = "";
		
		if(list != null) {
			page = "views/myPage/usingInfo.jsp";
		request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사용내역 조회 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}*/
		
		
		System.out.println("들어옴");
		
		int usingInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		
		AhnUsingInfoVO responseUserVO = new AhnMyPageService().searchCheck(usingInfo);
		
		
		System.out.println("usingInfo : " + usingInfo);
		System.out.println("responseUserVO : " + responseUserVO);
		
		String page = "";
		if(responseUserVO != null) {
			request.setAttribute("responseUserVO", responseUserVO);
			page = "views/myPage/usingInfo.jsp";
			
		}else {
			request.setAttribute("msg", "정보가 없습니다.");
			page = "views/common/errorPage.jsp";
		}
	
		request.getRequestDispatcher(page).forward(request, response);
		
	
	}
		
		
		
		
		
		
		
		
		/*
		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));
		String propNm = request.getParameter("propNm");
		String useStartDt = request.getParameter("useStartDt");
		
		System.out.println("rentSeq : " + rentSeq);
		System.out.println("propNm : " + propNm);
		System.out.println("useStartDt : " + useStartDt);
		
		AhnUsingInfoVO reqAhnUsingInfoVO = new AhnUsingInfoVO();
		reqAhnUsingInfoVO.setRentSeq(rentSeq);
		reqAhnUsingInfoVO.setPropNm(propNm);
		reqAhnUsingInfoVO.setUseStartDt(useStartDt);
		
		AhnUsingInfoVO searchResult = new AhnMyPageService().searchCheck(reqAhnUsingInfoVO);
		
		String view = "";
		if(searchResult != null) {
			view = "views/myPage/usingInfo.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", searchResult);
			
			response.sendRedirect(view);
			
		}else {
			view = "views/common/errorPage.jsp";
		}*/
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}