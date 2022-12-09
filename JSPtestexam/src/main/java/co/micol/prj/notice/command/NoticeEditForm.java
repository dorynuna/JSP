package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEditForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 수정폼
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		// 본인이 쓴 글을 수정하여야 하므로 라이터불러오기
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		
		vo = dao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeEditForm.tiles"; //jsp로
	}

}
