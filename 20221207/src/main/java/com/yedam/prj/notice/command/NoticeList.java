package com.yedam.prj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.notice.service.NoticeService;
import com.yedam.prj.notice.service.NoticeVO;
import com.yedam.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 목록 보기
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();

		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		return "notice/noticeList.tiles";
	}

}
