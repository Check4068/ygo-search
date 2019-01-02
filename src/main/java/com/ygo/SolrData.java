package com.ygo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ygo.service.SolrCardService;

@Component
public class SolrData implements CommandLineRunner {
	
	@Autowired
	private SolrCardService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.pushSolr();
	}
}
