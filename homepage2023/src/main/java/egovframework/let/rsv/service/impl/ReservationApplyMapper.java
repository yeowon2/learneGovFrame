package egovframework.let.rsv.service.impl;

import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("reservationApplyMapper")
public interface ReservationApplyMapper {

	// 기존 신청여부
	int duplicateApplyCheck(ReservationApplyVO vo) throws Exception;

	// 예약자 등록하기
	void insertReservationApply(ReservationApplyVO vo) throws Exception;
	
}
