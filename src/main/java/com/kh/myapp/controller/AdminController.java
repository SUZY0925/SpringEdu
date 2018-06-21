package com.kh.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired(required=true)
	@Qualifier("memberServiceImplXML")
	//@Qualifier("memberDAOImplXML")
	MemberService memberService;
	
	@RequestMapping("/admin")
	public void admin() {
		
	}
	
	//회원목록
		@RequestMapping(value = "/memberList")
		public String memberList(Model model) {
			List<MemberVO> alist = memberService.getMemberList();
			model.addAttribute("memberVOS",alist);
			return "/member/memberList";
		}
}
