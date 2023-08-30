package egovframework.let.crudtest.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.crudtest.service.CrudtestService;
import egovframework.let.crudtest.service.CrudtestVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller
public class CrudtestController {

	@Resource(name = "crudtestService")
	private CrudtestService crudtestService;
	
	//CRUD 목록 가져오기
	@RequestMapping(value="/crudtest/selectList.do")
	public String selectList(@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(crudtestVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(crudtestVO.getPageUnit());
		paginationInfo.setPageSize(crudtestVO.getPageSize());
		
		crudtestVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		crudtestVO.setLastIndex(paginationInfo.getLastRecordIndex());
		crudtestVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<EgovMap> resultList = crudtestService.selectCrudtestList(crudtestVO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = crudtestService.selectCrudtestListCnt(crudtestVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		return "crudtest/CrudtestSelectList";			
	}
	
	//CRUD 가져오기
	@RequestMapping(value="/crudtest/select.do")
	public String select (@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user =(LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		CrudtestVO result = crudtestService.selectCrudtest(crudtestVO);
		
		model.addAttribute("result", result);
		return "crudtest/CrudtestSelect";
	}
	
	//CRUD 등록/수정
	@RequestMapping(value="/crudtest/crudtestRegist.do")
	public String CrudRegist (@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user =(LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/crudtest/CrudtestSelectList";
		} else {
			model.addAttribute("USER_INFO", user);
		}
		
		CrudtestVO result = new CrudtestVO();
		
		//egovframework.let.utl.fcc.service.EgovStringUtil
		if(!EgovStringUtil.isEmpty(crudtestVO.getTestId())) {
			result = crudtestService.selectCrudtest(crudtestVO);
			//본인 및 관리자만 허용
			if(!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId())) {
				model.addAttribute("message", "로그인 후 사용가능합니다.");
				return "forward:crudtest/CrudtestSelectList";
			}
		}
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionBoard");
		
		return "crudtest/CrudtestRegist";
	}
	
	//CRUD 등록하기
	@RequestMapping(value="/crudtest/insert.do")
	public String insert(@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
//		// 이중 서브밋 방지 체크
	if(request.getSession().getAttribute("sessionBoard") != null) {
		return "forward:/crudtest/selectList.do";
	}
	
	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
	if (user == null || user.getId() == null) {
		model.addAttribute("message", "로그인 후 사용가능합니다.");
		return "forward:/crudtest/selectList.do";
	}
	
	//INSERT
	crudtestService.insertCrudtest(crudtestVO);
	
	// 이중 서브밋 방지
	request.getSession().setAttribute("sessionBoard", crudtestVO);
	
	return "forward:/crudtest/selectList.do"; 
	}

	//CRUD 수정하기
	@RequestMapping(value="/crudtest/update.do")
	public String update(@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
		// 이중 서브밋 방지 체크
		if(request.getSession().getAttribute("sessionBoard") != null) {
			return "forward:/crudtest/selectList.do";
		}
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if (user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/crudtest/selectList.do";}
		
		crudtestService.updateCrudtest(crudtestVO);
		
		// 이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", crudtestVO);
		
		return "forward:/crudtest/selectList.do";
	}
	
	//CRUD 삭제하기
	@RequestMapping(value="/crudtest/delete.do")
	public String delete(@ModelAttribute("searchVO") CrudtestVO crudtestVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if (user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/crudtest/selectList.do";
		}
		
		crudtestService.deleteCrudtest(crudtestVO);
		return "forward:/crudtest/selectList.do";
	}
	
	}

