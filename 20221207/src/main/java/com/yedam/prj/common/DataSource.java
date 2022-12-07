package com.yedam.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource { //싱글톤 class : 오직 인스턴스를 하나만 생성할 수 있는것 = 장점 : 초기화하지않고 불러서 쓸수있다.
	private static SqlSessionFactory sqlSessionFactory; // 변수명줄이지말고 클래스명 맨앞 대문자만 소문자로 바꿔서 그대로 써라
	private DataSource() {}; // 생성자 : 내클래스와 동일한 메소드명. 외부에서 나를 새엇ㅇ하지못하도록 프라이빗으로 생성
	
	public static SqlSessionFactory getInstance() {
		
		String resource = "config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
