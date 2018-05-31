/*package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.member.vo.MemberVO;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/login")	// 중복되는 경로중에 제일 상위경로에 해당되는 곳을 공통적으로 사용한다;;?
@SessionAttributes("user")	// session에 대한 속성 이름을 user로 가져가겠다는 말
public class old_LoginController {
	
		// forward : 서버내에서 페이지 이동... request와 response 정보를 같이 가져가는거임. (건내주기)
		// redirect : 2번 호출되는 구조, request와 response를 새로 요청하는 형식 (최초 요청을 받는 URL1에서 클라이언트에 redirect할 URL2를 리턴하고 Client에서는 새로운 요청을 생성하여 URL2에 다시 요청을 보낸다..)
		// redirect에서 파라미터를 가지고 갈 수 있는 방법은 get방법뿐이다.
	
	@Autowired
	//@Qualifier("loginServiceImpl")
	@Qualifier("loginServiceImplXML")
	LoginService loginService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(old_LoginController.class);
	
	// 로그인화면 보여주기
	@RequestMapping("/logIN")
	public String logIn(Model model) {	// model이라는 객체에 membervo를 심어서 login.jsp에 보내서 form과 이름이 같은 객체(ui단의 form의 name = memberVO 객체이름)와 바인딩이 됨. 이름이 틀리면 오류남 
		model.addAttribute("user", new MemberVO());
		return "login/login";	// views폴더의 login폴더의 login.jsp
	}
	// 만약 return이 없는 void형식일 경우 요청경로와 같은곳으로 가게됨 ( logIn()가 void일 경우 /login/logIN.jsp으로 가게됨 )
	
	
	// 로그인 처리 부분
	@RequestMapping("/memLoginOK")	// 위에서 user라는 모델에 넣기로 했기때문에 view에서도 그렇게 받아 넣었고, @ModelAttribute에 user라는 이름으로 준거임.. memberVO는 횐갑할때 써서 다른거씀
 	public String memLoginOK(@Valid @ModelAttribute("user") MemberVO user, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "login/login";	// forward?
		}else { // 오류가 없을 경우
			
			// 1. 회원정보 가져오기
			MemberVO memberVO = loginService.getMember(user);
			if(memberVO != null) {
				// 2. 회원정보 세션에 담기
				model.addAttribute("user", memberVO);
				return "redirect:/";
			} else {
				return "login/login";
			}
		}
	}
	
		// 로그아웃 처리 부분
	@RequestMapping("/logOut")
	public String logOut(@ModelAttribute("user") MemberVO user, SessionStatus sessionStatus) {
		sessionStatus.setComplete();	// 세션 마무으리,,
		
		
		return "redirect:/";
	}
}
*/