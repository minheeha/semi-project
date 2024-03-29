package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.SetRegPermissionsDao;
import com.kh.hp.admin.model.dao.UpdateOneUserDao;
import com.kh.hp.admin.model.dao.UseHistoryDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.SetRegPermissionsVO;
import com.kh.hp.admin.model.vo.UseHistoryVO;

public class SetRegPermissionsService {
	
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);


		return listCount;
	}

	
	//대관등록권한설정
	public ArrayList<SetRegPermissionsVO> SetRegPermissionsList (int currentPage, int limit) {
	
		System.out.println("대관등록권한설정 서비스까지 왔나요?");
		
		Connection con = getConnection();
		
		ArrayList<SetRegPermissionsVO> SetRegPermissionsVOList = new SetRegPermissionsDao().SetRegPermissionsList(con,currentPage, limit);

		close(con);

		return SetRegPermissionsVOList;
	

	}

	//대관등록권한설정 전체 카운팅 
	public int SetRegListCount() {
		
		Connection con = getConnection();

		int listCount = new SetRegPermissionsDao().SetRegListCount(con);

		return listCount;

		}

	}


