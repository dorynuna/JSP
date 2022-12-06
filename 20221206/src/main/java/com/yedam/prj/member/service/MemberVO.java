package com.yedam.prj.member.service;

import lombok.Getter;
import lombok.Setter;

// DB 테이블을 보면서 변수명,타입 유의해가면서 만들어라
@Setter
@Getter
public class MemberVO {
	private String memberName;
	private String memberId;
	private String memberPassword;
	private int memberAge;
	private String memberAddress;
	private String memberTel;
	private String memberAuthor;
}
