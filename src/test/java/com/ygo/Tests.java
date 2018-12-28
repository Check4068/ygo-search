package com.ygo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygo.db.mapper.MonsterMapper;
import com.ygo.db.model.Monster;
import com.ygo.db.service.HashService;
import com.ygo.db.service.MagTraService;
import com.ygo.db.service.MonsterService;
import com.ygo.model.CardVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

	@Autowired
	private HashService a;
	
	@Test
	public void contextLoads() throws Exception {
		a.groupByArrow();
	}

}
