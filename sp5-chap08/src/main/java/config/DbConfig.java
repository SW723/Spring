package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);//컨넥션 풀을 초기화 할때 생성할 초기 컨넥션 개수를 지정
		ds.setMaxActive(10);//컨넥션 풀에서 가져올 수 있는 최대 컨넥션 개수를 지정 기본 값은  100이다
		ds.setTestWhileIdle(true);//유휴 컨넥션을 검사
		ds.setMinEvictableIdleTimeMillis(60000 * 3);//최소 유휴시간 3분 즉,3분동안 쿼리를  실행하지 않으면  DB연결을 끊는다.
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);//10초 주기로 유휴 컨넥션이 유효한 지 여부를 검사헌다.
		return ds;
	}
}
