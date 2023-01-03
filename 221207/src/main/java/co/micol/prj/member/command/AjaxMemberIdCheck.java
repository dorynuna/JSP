package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse reponse) {
		// 아이디 중복체크를 Ajax로 처리한다.
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("id");
		String result = "1"; // 기본값으로 아이디를사용할 수 있도록 하기위해 / 존재하지않으면 1
		
		boolean b = dao.isIdCheck(id);
		if(!b) {
			result = "0";  // 존재하면 0
		}
		return "Ajax:"+result;  //ajax 처리하는 것을 view Resolve에 알림
	}

}
