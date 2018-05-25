package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller		
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/memberJoinOK", method = RequestMethod.POST)
	public String memberJoinOK(@Valid MemberVO memberVO, BindingResult result) {
		if(result.hasErrors()) {
			logger.info("회원가입 오.류.발.생.★");
		}else {
			memberService.memberInsert(memberVO);
		}
		return "index";
	}

	@RequestMapping(value = "/memberJoin")
	public void memberJoin(Model model) {
		model.addAttribute("memberVO",new MemberVO());
	}

	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public String memberList() {
		logger.info("memberList");
		return "memberList";
	}
}
