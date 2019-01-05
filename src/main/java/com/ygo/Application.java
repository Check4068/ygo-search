package com.ygo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ygo.service.RedisPackageService;
import com.ygo.service.SolrCardService;

@SpringBootApplication
@MapperScan(basePackages = { "com.ygo.mapper" })
public class Application implements CommandLineRunner {
	
	@Autowired
	private SolrCardService service;
	
	@Autowired
	private RedisPackageService infoService;
	
	@Override
	public void run(String... args) throws Exception {
		service.pushSolr();
		infoService.pushRedis();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
