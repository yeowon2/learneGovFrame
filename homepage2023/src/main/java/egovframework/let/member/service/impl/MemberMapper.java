package egovframework.let.member.service.impl;


import egovframework.let.member.service.MemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

//자바파일이 mapper를 annotation을 지정해주도록 적어야함
@Mapper("memberMapper")

public interface MemberMapper {

	// 회원ID찾기
	MemberVO findId(MemberVO vo) throws Exception;

	// 회원 비밀번호 찾기
	MemberVO findPassword(MemberVO vo) throws Exception;

	// 회원 비밀번호 업데이트
	void passwordUpdate(MemberVO vo) throws Exception;

}
