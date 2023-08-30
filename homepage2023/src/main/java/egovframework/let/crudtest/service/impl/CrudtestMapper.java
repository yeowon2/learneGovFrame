package egovframework.let.crudtest.service.impl;

import java.util.List;

import egovframework.let.crudtest.service.CrudtestVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

//자바파일이 mapper를 annotation을 지정해주도록 적어야함
@Mapper("crudtestMapper")

public interface CrudtestMapper {
	
	//CRUD 목록 가져오기
	List<EgovMap> selectCrudtestList(CrudtestVO vo) throws Exception;
	
	//CRUD 목록 수
	int selectCrudtestListCnt(CrudtestVO vo) throws Exception;
	
	//CRUD 가져오기
	CrudtestVO selectCrudtest(CrudtestVO vo) throws Exception;
	
	//CRUD 등록
	void insertCrudtest(CrudtestVO vo) throws Exception;

	//CRUD 수정하기 
	void updateCrudtest(CrudtestVO vo) throws Exception;
	
	//CRUD 삭제하기 
	void deleteCrudtest(CrudtestVO vo) throws Exception;
	
}
