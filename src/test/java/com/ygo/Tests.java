package com.ygo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygo.mapper.MonsterMapper;
import com.ygo.model.db.Monster;
import com.ygo.model.vo.CardResponseVO;
import com.ygo.service.HashService;
import com.ygo.service.MagTraService;
import com.ygo.service.MonsterService;

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
