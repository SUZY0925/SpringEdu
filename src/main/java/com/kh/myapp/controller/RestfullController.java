package com.kh.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@RestController // 리소스(데이터) 객체를 반환하는데 사용(JSON, XML, 문자열)
@Controller
@SessionAttributes("find")
public class RestfullController {
	
	@Autowired(required=true)
	@Qualifier("memberServiceImplXML")
	MemberService memberService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	// 아이디 찾기
	@RequestMapping("/findID")
	public String findID(@ModelAttribute("find") MemberVO find,BindingResult result, Model model){
		if(result.hasErrors()) {
			return "redirect:/";	
		}else {
			MemberVO memberVO = memberService.findID(find);
				return memberVO.getId();
		}
	}

	// 비밀번호 찾기
	@RequestMapping("/findPW")
	public String findPW(@ModelAttribute("find") MemberVO find,BindingResult result, Model model){
		if(result.hasErrors()) {
			return "redirect:/";	
		}else {
			MemberVO memberVO = memberService.findPW(find);
				return memberVO.getPasswd();
			}
	}
	
	
	/*@RequestMapping("/member")
	public MemberVO member(@RequestParam String id) {
		MemberVO memberVO = null;
		memberVO = memberService.getByMemberId(id);
		return memberVO;
	}*/
	
	//produces = "application/json"  : json으로 전송?하겠다
	@RequestMapping(value="/mem", method = RequestMethod.GET, produces = "application/json")
   public MemberVO member(@RequestParam("id") String id) {
      MemberVO memberVO = null;
      memberVO = memberService.getByMemberId(id);
      return memberVO;
   }
	
	@RequestMapping(value="/mem2", method = RequestMethod.GET, produces = "application/xml")
   public MemberVO member2(HttpServletRequest request) {
      String id = request.getParameter("id");
      MemberVO memberVO = null;
      memberVO = memberService.getByMemberId(id);
      return memberVO;
   }

	
	@RequestMapping(value="/memberList", method=RequestMethod.GET)
   public List<MemberVO> memberList() {
		
      List<MemberVO> list = new ArrayList<>();
      MemberVO memberVO = new MemberVO();
      memberVO.setId("admin@kh.com");
      memberVO.setPasswd("1234");
      memberVO.setName("홍길동");
      memberVO.setPhone("01012345678");
      list.add(memberVO);
      
      MemberVO memberVO2 = new MemberVO();
      memberVO2.setId("admin2@kh.com");
      memberVO2.setPasswd("1234");
      memberVO2.setName("홍길동2");
      memberVO2.setPhone("01012345678");
      list.add(memberVO2);
      
      
      return list;
   }
	
	
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap() {
		Map<Integer,MemberVO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			MemberVO memberVO = new MemberVO();
			memberVO.setId("admin"+i+"@kh.com");
			memberVO.setPasswd("1234"+i);
			memberVO.setName("홍길동"+i);
			memberVO.setPhone("01012345678"+i);
			map.put(i, memberVO);
		}
		
		return map;
	}
	
	@RequestMapping("/arr")
	public String[] array() {
		String[] str = new String[] {"홍길동","홍길서","홍길남","홍길복"};
		return str;
	}
	
	
}
