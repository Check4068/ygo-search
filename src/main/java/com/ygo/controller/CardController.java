package com.ygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ygo.model.vo.CardResponseVO;
import com.ygo.model.vo.CardRequestVO;
import com.ygo.service.MagTraService;
import com.ygo.service.MonsterService;
import com.ygo.util.Paging;

@RestController
public class CardController {

	@Autowired
	private MonsterService monsterService;

	@Autowired
	private MagTraService magTraService;

	@RequestMapping("/card")
	public Object searchCard(CardRequestVO vo, Integer start, Integer row) throws Exception {
		if (vo.getType() != 0) {
			return new Paging<CardResponseVO>(start, magTraService.count(vo), row, magTraService.searchMagTra(vo, start, row));
		}

		return new Paging<CardResponseVO>(start, monsterService.totalNum(vo), row, monsterService.searchMonster(vo, start, row));
	}
}
