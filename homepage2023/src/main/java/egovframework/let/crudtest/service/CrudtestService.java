package egovframework.let.crudtest.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface CrudtestService {
	
	//CrudTest 목록 가져오기
	public List<EgovMap> selectCrudtestList(CrudtestVO vo) throws Exception;
	
	//CrudTest 목록 수
	public int selectCrudtestListCnt(CrudtestVO vo) throws Exception;

	//CrudTest 가져오기 (상세정보)
	public CrudtestVO selectCrudtest(CrudtestVO vo) throws Exception;
		
	//CrudTest 등록하기 
	public String insertCrudtest(CrudtestVO vo) throws Exception;
	
	//CrudTest 수정하기 
	public void updateCrudtest(CrudtestVO vo) throws Exception;
	
	//CrudTest 삭제하기 
	public void deleteCrudtest(CrudtestVO vo) throws Exception;
}
