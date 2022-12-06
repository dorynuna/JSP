package com.yedam.prj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 처음 도착하는 페이지로 가는 것
		return "main/main"; //돌아갈 jsp페이지명
	}

}
