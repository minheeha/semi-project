package com.kh.hp.myPage.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageService {

	public AhnMyPageVO selectOne(int userSeq) {
		Connection con = getConnection();
		AhnMyPageVO responseUserVO = new AhnMyPageDao().selectOne(con, userSeq);
		close(con);
		
		return responseUserVO;
	}

	/*public AhnLevelupVO insertLevelOne(int levelUpInfo) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().insertLevelOne(con, levelUpInfo);
		close(con);
		
		return responseUserVO;
	}*/
	
	public AhnAttachmentVO insertLevelOne(int levelUpInfo, AhnAttachmentVO reqAhnAttachmentVO) {
		Connection con = getConnection();
		AhnAttachmentVO responseUserVO = new AhnMyPageDao().insertLevelOne(con, levelUpInfo, reqAhnAttachmentVO);
		close(con);
		
		return responseUserVO;
	}
	
	
	
	
	
	
	
	
	
	
	
	

/*	public ArrayList<AhnApplyInfoVO> searchCheck(int usingInfo) {

		Connection con = getConnection();
		
		ArrayList<AhnApplyInfoVO> list = new AhnMyPageDao().searchCheck(con, usingInfo);
		
		close(con);
		
		return list;
	}*/
	
	public int getListCount(int usingInfo) {
		Connection con = getConnection();
		
		int listCount = new AhnMyPageDao().getListCount(con, usingInfo);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<AhnApplyInfoVO> selectList(int usingInfo, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnApplyInfoVO> list = new AhnMyPageDao().selectList(con, usingInfo, currentPage, limit);
		
		close(con);
		
		return list;
	}


	
	
	
	
	
	
	/*public AhnUsingInfoVO searchCheck(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}*/

	/*public AhnUsingInfoVO updateUsingOne(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().updateUsingOne(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}*/

	/*public AhnUsingInfoVO searchCheck(AhnUsingInfoVO reqAhnUsingInfoVO) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, reqAhnUsingInfoVO);
		close(con);
		
		return responseUserVO;
	}*/
	
}
