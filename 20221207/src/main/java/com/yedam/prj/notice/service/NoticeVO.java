package com.yedam.prj.notice.service;

import java.sql.Date; // 날짜면 sql 시분초면 util

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private Date noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noitceHit;
	
	private int attechId; // join을 위한 확장
	private String noticeFile;
	private String noticeFileDir;
}
