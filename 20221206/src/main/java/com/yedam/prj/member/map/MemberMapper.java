package com.yedam.prj.member.map;

import java.util.List;

import com.yedam.prj.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList(); // 전체조회
	MemberVO memberSelect(MemberVO vo); // 단건조회 또는 로그인
	int memberInsert(MemberVO vo); // 입력
	int memberDelete(MemberVO vo); // 삭제
	int memberUpdate(MemberVO vo); // 업데이트
	
	boolean isIdCheck(String id); // 
}
