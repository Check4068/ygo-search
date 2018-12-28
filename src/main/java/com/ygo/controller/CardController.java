package com.ygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ygo.db.service.MonsterService;
import com.ygo.vo.MonsterVO;

@RestController
public class CardController {
	
	@Autowired
	private MonsterService monsterService;

	@RequestMapping("/card")
	public Object searchCard(MonsterVO vo) {
		try {
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
