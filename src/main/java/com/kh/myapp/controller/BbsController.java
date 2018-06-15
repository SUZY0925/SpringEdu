package com.kh.myapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.service.BbsService;

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
	
	@RequestMapping(value="/list",method = GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", bbsService.list());
	}









}
