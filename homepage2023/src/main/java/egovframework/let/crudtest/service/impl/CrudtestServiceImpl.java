package egovframework.let.crudtest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.crudtest.service.CrudtestService;
import egovframework.let.crudtest.service.CrudtestVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("crudtestService")
public class CrudtestServiceImpl extends EgovAbstractServiceImpl implements CrudtestService{

	@Resource(name = "crudtestMapper")
	private CrudtestMapper crudtestMapper;
	
	@Resource(name = "egovCrudtestIdGnrService")
	private EgovIdGnrService idgenService;
	
	//CRUD 목록 가져오기
	public List<EgovMap> selectCrudtestList(CrudtestVO vo) throws Exception {
		return crudtestMapper.selectCrudtestList(vo);
	}
	
	//CRUD 목록 수
	public int selectCrudtestListCnt(CrudtestVO vo) throws Exception {
		return crudtestMapper.selectCrudtestListCnt(vo);
	}
	
	//CRUD 등록하기 
	public String insertCrudtest(CrudtestVO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setTestId(id);
		crudtestMapper.insertCrudtest(vo);
		
		return id;
	}
	
	//CRUD 가져오기
	public CrudtestVO selectCrudtest(CrudtestVO vo) throws Exception {
		return  crudtestMapper.selectCrudtest(vo);
	}
	
	//CRUD 수정하기 
	public void updateCrudtest(CrudtestVO vo) throws Exception {
		crudtestMapper.updateCrudtest(vo);
	}
	
	//CRUD 삭제하기 
	public void deleteCrudtest(CrudtestVO vo) throws Exception {
		crudtestMapper.deleteCrudtest(vo);
		}
	}

