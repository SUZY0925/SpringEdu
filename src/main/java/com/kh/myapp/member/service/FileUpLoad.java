package com.kh.myapp.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.myapp.member.vo.MemberVO;

@Service
public class FileUpLoad {
	public boolean upload(MemberVO memberVO, HttpServletRequest request){
		boolean isUpload = false;
		
		HttpSession session = request.getSession();
		
		// 웹어플리케이션 root정보 알기
		String rootPath = session.getServletContext().getRealPath("/");
		String attachPath = "resources\\uploadFile\\";
		
		// 메모리상의 임시파일을 읽어옴
		MultipartFile uploadfile = memberVO.getUploadFile();
		
		if(uploadfile != null ) {
			// 파일의 오리지널이름을 얻어온 다음 뒤에 생성시간을 붙이면 유니크해짐,,!
			String newFileName =  System.currentTimeMillis() + "_" + uploadfile.getOriginalFilename();
			
			// 새 파일 생성~
			File file = new File(rootPath+attachPath+newFileName);
			
			try {
				// 임시파일을 서버에 저장
				uploadfile.transferTo(file);
				memberVO.setFilename(attachPath+newFileName);
				
				isUpload = true;
			} catch (IOException e) {
				isUpload = false;
				e.printStackTrace();
			}
		}
		return isUpload;
	}
}
