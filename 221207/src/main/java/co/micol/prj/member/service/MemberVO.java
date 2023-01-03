package co.micol.prj.member.service;

import lombok.Getter;
import lombok.Setter;

//DTO
@Setter // 주석은 옆에
@Getter
public class MemberVO {
	private String memberId;
	private String memberName;
	private String memberPassword;
	private int memberAge;
	private String memberAddress;
	private String memberTel;
	private String memberAuthor;
}
