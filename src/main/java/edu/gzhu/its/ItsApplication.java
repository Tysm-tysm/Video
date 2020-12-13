package edu.gzhu.its;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class ItsApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		System.out.print("视频上传项目启动类2.==="+"\n");
		return application.sources(ItsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ItsApplication.class, args);
	}

}
