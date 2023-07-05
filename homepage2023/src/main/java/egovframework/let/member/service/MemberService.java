package egovframework.let.member.service;

public interface MemberService {

	public int duplicateCheck(MemberVO vo) throws Exception;

	public String insertJoin(MemberVO vo) throws Exception;
}
