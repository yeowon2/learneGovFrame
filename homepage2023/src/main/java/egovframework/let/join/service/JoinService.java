package egovframework.let.join.service;

public interface JoinService {

	public int duplicateCheck(JoinVO vo) throws Exception;

	public String insertJoin(JoinVO vo) throws Exception;
}
