package com.yedam.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 리퀘스트,리스폰 결과받아서 스트링으로 돌려준다.
	String exec(HttpServletRequest request, HttpServletResponse response);
	
	
}
