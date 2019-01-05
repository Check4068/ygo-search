package com.ygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ygo.model.vo.CardRequestVO;
import com.ygo.service.CardService;

@RestController
public class CardController {

	@Autowired
	private CardService s;

	@RequestMapping("/card")
	public Object searchCard(CardRequestVO vo, Long start, Integer row) throws Exception {
		return s.getCard(vo, start, row);
	}
}
