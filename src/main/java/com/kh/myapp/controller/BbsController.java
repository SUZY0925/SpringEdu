package com.kh.myapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.service.BbsService;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	@Qualifier("bbsServiceImplXML")
	private BbsService bbsService;
	
	@RequestMapping(value="/write", method = GET)
	public void writeForm(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("write GET...");
	}
	
	@RequestMapping(value="/write", method = POST)
	public String writePost(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("write POST....");
		logger.info(bbsdto.toString());
		
		bbsService.write(bbsdto);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/listAll",method = GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("listAll", bbsService.list());
	}
	
	@RequestMapping(value="/list",method = GET)
	public void list(HttpServletRequest request, Model model) throws Exception {
		bbsService.list(request);
	}

	@RequestMapping(value="/view", method = GET)
	public void view(@RequestParam("bnum") int bnum, Model model) throws Exception {
		/*bbsService.updateHit(bnum);*/
		model.addAttribute("view", bbsService.view(bnum));
	}
	
	@RequestMapping(value="/modify", method = POST)
	public String modify(@RequestParam("bnum") int bnum, BbsDTO bbsdto, Model model) throws Exception {
		logger.info("수정한내용 : " + bbsdto.toString());
		bbsService.modify(bbsdto);
		model.addAttribute("view",bbsdto);
		return "redirect:/bbs/view?bnum="+bnum;
	}
	
	@RequestMapping(value="/delete", method = GET)
	public String delete(@RequestParam("bnum") int bnum) throws Exception {
		bbsService.delete(bnum);
		return "redirect:/bbs/list";
	}
	
	
	@RequestMapping(value="/reply", method = GET)
	public void replyForm(@RequestParam("bnum") int bnum,BbsDTO bbsdto, Model model) throws Exception {
		model.addAttribute("replyView", bbsService.replyView(bnum));
		logger.info("답글 양식 페이지 이동");
	}
	
	
	@RequestMapping(value="/reply", method = POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("답글내용 : "+bbsdto.toString());
		bbsService.reply(bbsdto);
		return "redirect:/bbs/list";
	}
	

	@RequestMapping(value="/reReply",method=GET)
	public String reReply() {
		
		return "/rbbs/reply";
	}

}
