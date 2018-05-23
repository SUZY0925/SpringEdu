package com.kh.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/* @RequestMapping("/member") */
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/memberJoinOK", method = RequestMethod.POST)
	public String memberJoinOK() {

		return "index";
	}

	@RequestMapping(value = "/memberJoin")
	public String memberJoin() {
		logger.info("memberJoin");
		return "/member/memberJoin";
	}

	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public String memberList() {
		logger.info("memberList");
		return "memberList";
	}
}
