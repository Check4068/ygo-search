package com.ygo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Service;
import com.ygo.mapper.MagTraMapper;
import com.ygo.mapper.MonsterMapper;
import com.ygo.model.db.SolrCard;

@Service
public class SolrCardService {

	@Autowired
	private MonsterMapper monsterMapper;
	
	@Autowired
	private MagTraMapper magTraMapper;
	
	@Autowired
	private SolrTemplate template;
	
	public void pushSolr() throws Exception {
		Query query = new SimpleQuery("*:*");
		Page<SolrCard> page = template.query("new_core", query, SolrCard.class);
		if (page.getTotalElements() > 0) {
			return;
		}

		int start = 0;
		List<SolrCard> cards = monsterMapper.findAllMonster(start, 1000);
		while(cards != null && cards.size() > 0) {
			template.saveBeans("new_core", cards);
			start = start + 1000;
			cards = monsterMapper.findAllMonster(start, 1000);
		}
		
		start = 0;
		cards = magTraMapper.findAllMagtra(start, 1000);
		while(cards != null && cards.size() > 0) {
			template.saveBeans("new_core", cards);
			start = start + 1000;
			cards = magTraMapper.findAllMagtra(start, 1000);
		}
		
		template.commit("new_core");
	}
}
