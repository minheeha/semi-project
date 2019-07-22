package com.kh.hp.myPage.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.hp.myPage.model.dao.MyPageDao_mh;
import com.kh.hp.myPage.model.vo.MyPageUserVO;

public class MyPageService_mh {

	/**
	 * 마이페이지 현재 접속자 정보 불러오기
	 * @param userSeq
	 * @return
	 */
	public MyPageUserVO selectMyPageInfo(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		MyPageUserVO mypageInfo = new MyPageDao_mh().selectMyPageInfo(con, userSeq);

		close(con);

		return mypageInfo;
	}


	/**
	 * 마이페이지 - 유저 정보 수정
	 *
	 * @param myPageUserVO
	 * @return
	 */
	public MyPageUserVO updateMyPageInfo(MyPageUserVO myPageUserVO) {
		Connection con = getConnection();
		int updateResult = 0;
		int insertResult = 0;

		MyPageDao_mh myPageDao_mh = new MyPageDao_mh();
		// 1. seq를 가지고 dao에서 해당 유저 정보 VO에 담아서 가져오기
		MyPageUserVO responseMyPageUserVO = myPageDao_mh.selectMyPageInfo(con, myPageUserVO.getUserSeq());

		System.out.println("변경 전 : " + responseMyPageUserVO);
		System.out.println("변경 후 : " + myPageUserVO);

		// 2. myPageUserVO(요청VO)와 responseMyPageUserVO(응답VO - DB값)과 비교
		// 2-1. 값이 모두 같으면(변경 값이 없으면) - update문 실행 안함
		// 2-2. 값이 한개라도 다르면 update문 실행
		boolean type1 = responseMyPageUserVO.getUserNm().equals(myPageUserVO.getUserNm());
		boolean type2 = responseMyPageUserVO.getUserNick().equals(myPageUserVO.getUserNick());
		boolean type3 = responseMyPageUserVO.getUserPhone().equals(myPageUserVO.getUserPhone());


		/*변경 사항이 없을 경우 - 업데이트 안함*/
		if(type1 && type2 && type3) {
			System.out.println("변경사항 없음!");


		/*변경 사항이 하나라도 있을 경우 업데이트 함*/
		} else {
			updateResult = myPageDao_mh.updateMyPageInfo(con, myPageUserVO);
			System.out.println("result:::"+insertResult);
			if(updateResult > 0) {
				// 3. 내역을 입력
				if(type1) {
					myPageUserVO.setUserNm(null);
				}

				if(type2) {
					myPageUserVO.setUserNick(null);
				}

				if(type3) {
					myPageUserVO.setUserPhone(null);
				}
				insertResult = myPageDao_mh.insertUpdatedMyPageInfo(con, myPageUserVO);
			}

		}

		if(updateResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		// 3-1. 닉네임, 이름, 핸드폰 정보중 바뀐 값만 추출



/*
		if(result > 0) {
			System.out.println("성공");
			MyPageUserVO responseMyPageUserVO = myPageDao_mh.selectMyPageInfo(con, myPageUserVO.getUserSeq());
		} else {
			System.out.println("실패");
		}*/

		close(con);

		return responseMyPageUserVO;
	}


}


/*			(myPageUserVO.getUserNick().equals(responseMyPageUserVO.getUserNick() &&
myPageUserVO.getUserNm().equals(responseMyPageUserVO.getUserNm() &&
		myPageUserVO.getUserPhone().equals(responseMyPageUserVO.getUserPhone())		)	))*/