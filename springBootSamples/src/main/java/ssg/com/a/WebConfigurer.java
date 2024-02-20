package ssg.com.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//접속허가
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		//registry.addMapping("/**").allowedOrigins("http://localhost:3000/");
		registry.addMapping("/**").allowedOrigins("*");	//모든 포트번호를 허용
	}
	
	

}
