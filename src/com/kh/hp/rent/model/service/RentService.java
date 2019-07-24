package com.kh.hp.rent.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.rent.model.dao.RentDao;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.DetFacVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RefundTypeVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetFacVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
import com.kh.hp.rent.model.vo.RentListVO;
import com.kh.hp.rent.model.vo.RentRefundTypeVO;

public class RentService {

	/**
	 * 세부 시설 정보 가져오기
	 * @return
	 */
	public ArrayList<DetFacVO> selectDetFacAll() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<DetFacVO> detFacVOList = new RentDao().selectDetFacAll(con);

		close(con);

		return detFacVOList;
	}

	/**
	 * 환불 유형 가져오기
	 * @return
	 */
	public ArrayList<RefundTypeVO> selectRefunctTypeAll() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<RefundTypeVO> refundTypeVOList = new RentDao().selectRefunctTypeAll(con);

		close(con);

		return refundTypeVOList;
	}

	/**
	 * 대관 등록
	 * @param requestRentBasicVO
	 * @param facInfoVOList
	 * @param rentDetVOList
	 * @param cautionsVOList
	 * @param requestRentDetFacVOList
	 * @param rentImgVOList
	 * @param attachmentVOList
	 * @param requestRentCloseVO
	 * @param requestRentRefundTypeVO
	 * @return
	 */
	public int insertRentInfo(RentBasicVO requestRentBasicVO, ArrayList<FacInfoVO> facInfoVOList,
			ArrayList<RentDetVO> rentDetVOList, ArrayList<CautionsVO> cautionsVOList,
			ArrayList<RentDetFacVO> requestRentDetFacVOList, ArrayList<RentImgVO> rentImgVOList,
			ArrayList<AttachmentVO> attachmentVOList, RentCloseVO requestRentCloseVO,
			RentRefundTypeVO requestRentRefundTypeVO) {
		// TODO Auto-generated method stub
		/*
		RentBasicVO requestRentBasicVO = new RentBasicVO(); // 대관 기본 정보 테이블
		ArrayList<FacInfoVO> facInfoVOList = new ArrayList<FacInfoVO>(); 	// 시설안내 테이블
		ArrayList<RentDetVO> rentDetVOList = new ArrayList<RentDetVO>();	// 대관 상세정보 테이블
		ArrayList<CautionsVO> cautionsVOList = new ArrayList<CautionsVO>();	// 주의사항 테이블
		ArrayList<RentDetFacVO> requestRentDetFacVOList = new ArrayList<RentDetFacVO>();	// 대관세부시설 테이블
		ArrayList<RentImgVO> rentImgVOList = new ArrayList<RentImgVO>();	// 대관이미지 파일 테이블
		ArrayList<AttachmentVO> attachmentVOList = new ArrayList<AttachmentVO>();	// 첨부파일 테이블
		RentCloseVO requestRentCloseVO = new RentCloseVO();	// 대관별 휴무일 테이블

		RentRefundTypeVO requestRentRefundTypeVO = new RentRefundTypeVO();	// 대관별 환불유형
		*/

		Connection con = getConnection();
		RentDao rentDao = new RentDao();
		int insertRentBasicResult = 0;	// 대관 기본정보 테이블 삽입 결과
		int insertfacInfoResult = 0;	// 시설 안내 테이블 삽입 결과
		int insertRentDetResult = 0;	// 시설 안내 테이블 삽입 결과
		int insertCautionsResult = 0;	// 주의사항 테이블 삽입 결과
		int insertRentDetFacResult = 0;	// 대관세부시설 테이블 삽입 결과
		int insertrentImgResult = 0;	// 대관이미지 테이블 삽입 결과
		int insertAttachmentResult = 0;	// 첨부파일 테이블 삽입 결과
		int insertRentCloseResult = 0;	// 대관별 휴무일 테이블 삽입 결과
		int insertRentRefundTypeResult = 0;	// 대관별 환불유형 테이블 삽입 결과
		int result = 0;

		insertRentBasicResult = rentDao.insertRentBasic(con, requestRentBasicVO);

		// RENT_BASIC 테이블에 삽입을 성공하면,
		if(insertRentBasicResult == 1){

			// 현재 시퀀스 번호 가져오기
			int rentSeq = rentDao.selectRendSeq(con);
			System.out.println("rentSeq:::" + rentSeq);

			// 시설 안내 삽입
			for(FacInfoVO facInfoVO : facInfoVOList) {
				insertfacInfoResult = rentDao.insertfacInfo(con, facInfoVO, rentSeq);
			}

			// 대관 상세정보 삽입
			for(RentDetVO rentDetVO : rentDetVOList) {
				insertRentDetResult = rentDao.insertRentDet(con, rentDetVO, rentSeq);
			}

			// 주의사항 삽입
			for(CautionsVO cautionsVO : cautionsVOList) {
				insertCautionsResult = rentDao.insertCautions(con, cautionsVO, rentSeq);
			}

			// 대관세부시설 삽입
			for(RentDetFacVO rentDetFacVO : requestRentDetFacVOList) {
				insertRentDetFacResult = rentDao.insertRentDetFac(con, rentDetFacVO, rentSeq);
			}

			// 대관이미지 삽입
			for(int i=rentImgVOList.size()-1; i>=0; i--) {

				if(i == rentImgVOList.size()-1) {
					rentImgVOList.get(i).setImgType(1);
				} else {
					rentImgVOList.get(i).setImgType(2);
				}
				insertrentImgResult = rentDao.insertrentImg(con, rentImgVOList.get(i), rentSeq);
			}

			// 첨부파일 삽입
			for(AttachmentVO attachmentVO : attachmentVOList) {
				insertAttachmentResult = rentDao.insertAttachment(con, attachmentVO, rentSeq);
			}

			// 대관별 휴무일 삽입
			insertRentCloseResult = rentDao.insertRentClose(con, requestRentCloseVO, rentSeq);


			insertRentRefundTypeResult = rentDao.insertRentRefundType(con, requestRentRefundTypeVO, rentSeq);


			System.out.println("insertRentBasicResult:::" + insertRentBasicResult);
			System.out.println("insertfacInfoResult:::" + insertfacInfoResult);
			System.out.println("insertRentDetResult:::" + insertRentDetResult);
			System.out.println("insertCautionsResult:::" + insertCautionsResult);
			System.out.println("insertRentDetFacResult:::" + insertRentDetFacResult);
			System.out.println("insertrentImgResult:::" + insertrentImgResult);
			System.out.println("insertAttachmentResult:::" + insertAttachmentResult);
			System.out.println("insertRentCloseResult:::" + insertRentCloseResult);
			System.out.println("insertRentRefundTypeResult:::" + insertRentRefundTypeResult);

		}

		/*모든 insert 성공 시 commit*/
		if(insertRentBasicResult > 0
				&& insertfacInfoResult > 0
				&& insertRentDetResult > 0
				&& insertCautionsResult > 0
				&& insertRentDetFacResult > 0
				&& insertrentImgResult > 0
				&& insertAttachmentResult > 0
				&& insertRentCloseResult > 0
				&& insertRentRefundTypeResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	/**
	 * 리스트 페이징을 위해 카운트 가져오기
	 * @return
	 */
	public int selectCountRentList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		int count = 0;
		count = new RentDao().selectCountRentList(con);

		close(con);

		return count;
	}

	public ArrayList<RentListVO> selectRentList(int currentPage, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<RentListVO> rentListVOList = new RentDao().selectRentList(con, currentPage, limit);

		close(con);

		return rentListVOList;
	}

}
