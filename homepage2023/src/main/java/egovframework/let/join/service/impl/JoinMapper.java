package egovframework.let.join.service.impl;


import egovframework.let.join.service.JoinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

//자바파일이 mapper를 annotation을 지정해주도록 적어야함
@Mapper("joinMapper")

public interface JoinMapper {
	
	// ID 중복체크
	int duplicateCheck(JoinVO vo) throws Exception;

	// 회원등록
	void insertJoin(JoinVO vo) throws Exception;	
	
}
