package com.yedam.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.prj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃처리
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("name"); // 세션의 name 오브젝트니까 스트링으로 타입변환
		message += "님 정상적으로 로그아웃 처리되었습니다.";
		session.invalidate();
		request.setAttribute("message", message);
		return "member/memberLogin.tiles"; // 홈페이지 첫번째로 가져용
	}

}
