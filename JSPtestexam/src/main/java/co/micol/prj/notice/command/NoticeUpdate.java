package co.micol.prj.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 수정 처리
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeDate(Date.valueOf(request.getParameter("noticeDate")));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		vo.setNoticeFile(request.getParameter("noticeFile"));
		vo.setNoticeFileDir(request.getParameter("noticeFileDir"));
		// 쓰지않는 vo에대해서 적지못했음
		
		int n = dao.noticeUpdate(vo);
		if(n != 0) {
			request.setAttribute("message", "공지사항이 수정되었습니다.");
		}else {
			request.setAttribute("message", "공지사항이 수정 실패");
		}
		return "notice/noticeList.tiles";
	}

}
