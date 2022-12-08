package com.yedam.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.prj.notice.service.NoticeAttechVO;
import com.yedam.prj.notice.service.NoticeVO;

public interface NoticeMapper {

	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSelect(NoticeVO vo); // 첨부파일이 여러개면 리스트로 받음
	int noticeInsert(NoticeVO vo); // 게시글 저장
	int noticeUpdate(NoticeVO vo); // 게시글 수정
	int noticeDelete(NoticeVO vo); // 게시글 삭제

	int noticeAttechDelete(NoticeAttechVO vo); // 첨부파일 삭제
	int noticeAttechInsert(NoticeAttechVO vo); // 첨부파일 저장

	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String Val); // 게시글 내 검색을 위해
	// 마이바티스에서는 두개이상의 매개변수를 전달하려면 매퍼인터페이스에서
	// @param("변수이름") 변수타입 변수이름 : 이렇게 써줘야한다
}
