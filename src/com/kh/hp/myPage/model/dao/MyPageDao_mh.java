package com.kh.hp.myPage.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.vo.MyPageUserVO;

public class MyPageDao_mh {
	private Properties prop = new Properties();

	public MyPageDao_mh() {
		String fileName = MyPageDao_mh.class.getResource("/sql/myPage/myPage-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 마이페이지 현재 접속자 정보 불러오기
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public MyPageUserVO selectMyPageInfo(Connection con, int userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MyPageUserVO myPageInfo = null;

		String query = prop.getProperty("selectMyPageInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				myPageInfo = new MyPageUserVO();
				myPageInfo.setUserEmail(rset.getString("USER_EMAIL"));
				myPageInfo.setUserPwd(rset.getString("USER_PWD"));
				myPageInfo.setUserNm(rset.getString("USER_NM"));
				myPageInfo.setUserNick(rset.getString("USER_NICK"));
				myPageInfo.setUserPhone(rset.getString("USER_PHONE"));
				myPageInfo.setUserGradeCd(rset.getInt("USER_GRADE_CD"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return myPageInfo;
	}


	/**
	 * 마이페이지 유저 정보 업데이트
	 * @param con
	 * @param myPageUserVO
	 * @return
	 */
	public int updateMyPageInfo(Connection con, MyPageUserVO myPageUserVO) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMyPageInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, myPageUserVO.getUserNick());
			pstmt.setString(2, myPageUserVO.getUserNm());
			pstmt.setString(3, myPageUserVO.getUserPhone());
			pstmt.setInt(4, myPageUserVO.getUserSeq());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertUpdatedMyPageInfo(Connection con, MyPageUserVO myPageUserVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUpdatedMyPageInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myPageUserVO.getUserSeq());
			pstmt.setString(2, myPageUserVO.getUserNm());
			pstmt.setString(3, myPageUserVO.getUserNick());
			pstmt.setString(4, myPageUserVO.getUserPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}




}