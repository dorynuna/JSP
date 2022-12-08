package com.yedam.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.service.MemberVO;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class MemberEdit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 수정을 위한 데이터 호출 후 수정폼에 전달
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo = dao.memberSelect(vo);
		request.setAttribute("member", vo);
		
		return "member/memberEditForm";
	}

}
