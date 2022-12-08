package com.yedam.prj.member.command;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.prj.common.AES256Util;
import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.service.MemberVO;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인처리
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String password = request.getParameter("memberPassword");
		try {
			AES256Util aes = new AES256Util();
			try {
				password = aes.encrypt(password); 
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (GeneralSecurityException e ) {
				e.printStackTrace();	
			} // 암호화됨
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(); // 서버가 만들어 보관하고 있는 세션객체를 호출
		
		String message = null;
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(password);
		
		vo = dao.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());
			
			message = vo.getMemberName() +"님 환영합니다.";
			request.setAttribute("message", message);
			request.setAttribute("member", vo);
		} else {
			message = "아이디 또는 패스워드가 일치하지 않습니다.";
			request.setAttribute("message", message);
		}
		return "member/memberLogin.tiles";// 보여줄 페이지
	}

}
