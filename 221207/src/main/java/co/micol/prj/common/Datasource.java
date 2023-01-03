package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Datasource { // 싱글톤 class
	private static SqlSessionFactory sqlSessionFactory;

	private Datasource() {
	}; // 외부에서 나를 호출하지 못하도록

	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml"; // config 파일이랑 이름 같이하면 됨
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {

		}
		return sqlSessionFactory;
	}
}