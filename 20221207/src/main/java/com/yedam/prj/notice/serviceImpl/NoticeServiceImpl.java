package com.yedam.prj.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.prj.common.DataSource;
import com.yedam.prj.notice.map.NoticeMapper;
import com.yedam.prj.notice.service.NoticeAttechVO;
import com.yedam.prj.notice.service.NoticeService;
import com.yedam.prj.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	@Override
	public List<NoticeVO> noticeSelectList() {
		// 
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeAttechDelete(NoticeAttechVO vo) {
		// TODO Auto-generated method stub
		return map.noticeAttechDelete(vo);
	}

	@Override
	public int noticeAttechInsert(NoticeAttechVO vo) {
		// TODO Auto-generated method stub
		return map.noticeAttechInsert(vo);
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String Val) {
		// TODO Auto-generated method stub
		return map.noticeSearchList(key, Val);
	}

}
