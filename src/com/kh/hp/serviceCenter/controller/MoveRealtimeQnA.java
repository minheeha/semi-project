package com.kh.hp.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.vo.RealTimeVO;
import com.kh.hp.serviceCenter.model.service.ServiceCenterService;

/**
 * Servlet implementation class MoveRealtimeQnA
 */
@WebServlet("/moveRealtimeQnA.sc")
public class MoveRealtimeQnA extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRealtimeQnA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userSeq = ((UserVO)request.getSession().getAttribute("user")).getUserSeq();

		int result = new ServiceCenterService().selectHaveRoom(userSeq);

		// 대화 내용 가져오기
		ArrayList<RealTimeVO> realTimeVOs = new ServiceCenterService().selectConversationList(userSeq);

		System.out.println("realTimeVOs::::::::::::::"+realTimeVOs);

		String page = "";
		if(result > 0) {
			request.setAttribute("realTimeVOs", realTimeVOs);
			page = "views/serviceCenter/realTimeQnA.jsp";
		} else {
			page = "views/serviceCenter/realTimeCreateForm.jsp";
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
