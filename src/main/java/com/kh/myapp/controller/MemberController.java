package com.kh.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
@SessionAttributes("memberVO")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired(required=true)
	@Qualifier("memberServiceImplXML")
	//@Qualifier("memberDAOImplXML")
	MemberService memberService;
	
	
	
	// 회원가입
	@RequestMapping(value = "/memberJoin")
	public String memberJoin(Model model, HttpSession session) {
		
		model.addAttribute("memberVO",new MemberVO());
		return "/member/memberJoin";
	}
	
	// 회원가입 OK
	@RequestMapping(value = "/memberJoinOK", method = RequestMethod.POST)
	public String memberJoinOK(@Valid MemberVO memberVO, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("회원가입 오.류.발.생.★");
			return "/member/memberJoin";
		}else {
			memberService.memberInsert(memberVO);
			return "redirect:/member/memberList";
		}
	}

	// 회원정보수정
	@RequestMapping(value="/memberModify/{id:.+}")	// get방식 대신 스프링에서 지원하는 방식 사용 : url상의 주소 일부를 파라미터로 받을 수 있다. 콜론뒤에 정규표현식을 정할수있음. .+는 dot가 0개이상..?
	public String memberModify(@PathVariable String id, Model model) {
		model.addAttribute("memberVO",memberService.getByMemberId(id));
		return "/member/memberModify";
	}
	
	//회원정보수정OK
	@RequestMapping(value="/memberModifyOK", method = RequestMethod.POST)
	public String memberModifyOK(@Valid MemberVO memberVO, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("정보수정 오.류.발.생.★");
			return "/member/memberModify";
		}else {
			memberService.memberUpdate(memberVO);
			return "redirect:/member/memberList";
		}
	}
	
	// 회원탈퇴
	@RequestMapping(value="/memberDelete/{id:.+}")
	public String memberDelete(@PathVariable String id, Model model) {
		if(memberService.getByMemberId(id) != null) {
			memberService.memberDelete(id);
			return "redirect:/member/memberList";
		}else {
			return "/member/memberList";
		}
	}
	

	//회원목록
	@RequestMapping(value = "/memberList")
	public String memberList(Model model) {
		List<MemberVO> alist = memberService.getMemberList();
		model.addAttribute("memberVOS",alist);
		return "/member/memberList";
	}
	
	/*@RequestMapping("/findID")
	public void findID(@ModelAttribute("find") MemberVO find,BindingResult result, Model model){
		if(result.hasErrors()) {
			return "login/login";	
		}else {
			MemberVO memberVO = loginService.findID(find);
			if(memberVO != null) {
				model.addAttribute("login", memberVO);
				return "login/login";
			} else {
				return "login/login";
			}
		}
	}
	
	@RequestMapping("/findPW")
	public void findPW(@ModelAttribute("find") MemberVO find,BindingResult result, Model model){
		if(result.hasErrors()) {
			return "login/login";	
		}else {
			MemberVO memberVO = loginService.findPW(find);
			if(memberVO != null) {
				model.addAttribute("login", memberVO);
				return "redirect:/login/login";
			} else {
				return "login/login";
			}
		}
	}*/
}
