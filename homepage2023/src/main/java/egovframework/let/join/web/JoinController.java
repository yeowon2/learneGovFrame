package egovframework.let.join.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.LoginVO;
import egovframework.let.join.service.JoinVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class JoinController {
	
	// 약관 동의
	@RequestMapping(value="/join/siteUseAgree.do")
	public String siteUseAgree(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		return "join/SiteUseAgree";
	}
	
	// 회원 구분
	@RequestMapping(value="/join/memberType.do")
	public String memberType(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		return "join/MemberType";
	}
	
	// 회원 등록 폼
	@RequestMapping(value="/join/memberRegist.do")
	public String memberRegist(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model) throws Exception{
		
		return "join/MemberRegist";
	}
}