package com.yedam.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.service.MemberVO;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class MemberDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원삭제
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		int n = dao.memberDelete(vo);
		
		if(n != 0) {
			return "memberList.do";
		}else {
			request.setAttribute("message", "회원정보 삭제가 실패했습니다.");
			return "member/memberLogin.tiles";
		}		
	}

}

