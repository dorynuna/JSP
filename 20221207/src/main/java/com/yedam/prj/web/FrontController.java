package com.yedam.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.MainCommand;
import com.yedam.prj.common.Command;
import com.yedam.prj.member.command.AjaxMemberIdCheck;
import com.yedam.prj.member.command.MemberJoin;
import com.yedam.prj.member.command.MemberJoinForm;
import com.yedam.prj.member.command.MemberList;


//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap <String, Command>();
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 명령집단 map.put(k,V)
		map.put("/main.do",new MainCommand());//처음 실행하는 페이지
		map.put("/memberList.do", new MemberList());
		map.put("/memberJoinForm.do", new MemberJoinForm());//회원가입폼
		map.put("/AjaxMemberIdCheck.do", new AjaxMemberIdCheck());//회원가입폼
		map.put("/memberJoin.do", new MemberJoin());//회원가입폼
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석, 실행, 결과를 돌려주는 곳
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		// view Resolve start : 어떤페이지를 보여줄지
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("Ajax:")) {
				//ajax
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print(viewPage.substring(5));//Ajax:5글자니까 그 뒤부터 데이터다
			}else if(!viewPage.endsWith(".tiles")){
				viewPage = "WEB-INF/views/" + viewPage + ".jsp"; //타일즈적용안하는것
		
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage);
		}
		// view Resolve end
	}

}
