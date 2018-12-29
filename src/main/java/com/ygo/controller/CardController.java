package com.ygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygo.model.vo.MonsterVO;
import com.ygo.service.MonsterService;

@RestController
public class CardController {
	
	@Autowired
	private MonsterService monsterService;

	@RequestMapping("/card")
	public Object searchCard(MonsterVO vo) throws Exception {
		return monsterService.searchMonster(vo, 1, 100);
	}
}
