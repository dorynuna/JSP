package com.yedam.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.service.MemberVO;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		int n = 0;
		//String viewPage = null; // 돌려줄 페이지
		String message = null; // 메세지
		// 매퍼의 인서트쪽 변수갯수랑 같은지 확인해라. 총 일곱개
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberAge(Integer.valueOf(request.getParameter("memberAge"))); // age는 숫자니까 타입변환 근데 널값되면 오류남 회원가입시에 채워줘야한다.
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor("USER"); // 회원가입하면 권한 디폴트는 유저로 지정한다.

		n = dao.memberInsert(vo);
		if (n != 0) {
			message = "회원가입이 성공적으로 처리되었습니다.";
		} else {
			message = "회원가입이 실패했습니다.";
		}
		request.setAttribute("message", message);
		
		return "member/memberJoin.tiles";
	}

}
