package com.ygo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygo.basic.ArrowEnum;
import com.ygo.basic.AttributeEnum;
import com.ygo.basic.LimitEnum;
import com.ygo.basic.RaceEnum;
import com.ygo.basic.TypeEnum;
import com.ygo.model.db.CardPackInfo;
import com.ygo.model.db.SolrCard;
import com.ygo.model.vo.CardRequestVO;
import com.ygo.model.vo.CardResponseVO;
import com.ygo.model.vo.CardResponseVO.PackInfo;
import com.ygo.util.Paging;

@Service
public class CardService {

	@Autowired
	private SolrTemplate solr;

	@Autowired
	private RedisTemplate<String, String> redis;

	public Paging<CardResponseVO> getCard(CardRequestVO vo, Long start, Integer row) throws Exception {
		Query query = new SimpleQuery();
		Criteria criteria = new Criteria("cardType").contains(vo.getType().toString());
		criteria = is(criteria, vo.getName(), "cardKey");
		criteria = is(criteria, vo.getAtk(), "atk");
		criteria = is(criteria, vo.getDef(), "def");
		criteria = contains(criteria, vo.getLev(), "lev");
		criteria = contains(criteria, vo.getPend(), "pend");
		criteria = contains(criteria, vo.getLink(), "link");
		criteria = contains(criteria, LimitEnum.getName(vo.getLimit()), "ban");
		if (vo.getArrows() != null && vo.getArrows().size() > 0) {
			Criteria arrow = new Criteria("arrow");
			for (Integer integer : vo.getArrows()) {
				arrow.is(ArrowEnum.getName(integer));
			}

			query.addFilterQuery(new SimpleFilterQuery(arrow));
		}

		if (vo.getAttributes() != null && vo.getAttributes().size() > 0) {
			Criteria attribute = new Criteria("attribute");
			for (Integer integer : vo.getAttributes()) {
				attribute.is(AttributeEnum.getName(integer));
			}

			query.addFilterQuery(new SimpleFilterQuery(attribute));
		}

		if (vo.getOthers() != null && vo.getOthers().size() > 0) {
			Criteria type = new Criteria("type");
			for (Integer integer : vo.getOthers()) {
				type.is(TypeEnum.getName(integer));
			}

			query.addFilterQuery(new SimpleFilterQuery(type));
		}

		if (vo.getRaces() != null && vo.getRaces().size() > 0) {
			Criteria race = new Criteria("race");
			for (Integer integer : vo.getRaces()) {
				race.is(RaceEnum.getName(integer));
			}

			query.addFilterQuery(new SimpleFilterQuery(race));
		}

		query.addCriteria(criteria);
		query.setRows(row);
		query.setOffset((start - 1) * row);
		Page<SolrCard> page = solr.query("new_core", query, SolrCard.class);
		return new Paging<>(start, page.getTotalElements(), row, changeData(page.getContent()));
	}

	private List<CardResponseVO> changeData(List<SolrCard> cards) throws Exception {
		List<CardResponseVO> list = new ArrayList<CardResponseVO>();
		for (SolrCard solrCard : cards) {
			CardResponseVO vo = new CardResponseVO();
			vo.setArrow(solrCard.getArrow());
			vo.setAtk(solrCard.getAtk());
			vo.setAttribute(solrCard.getAttribute());
			vo.setBan(solrCard.getBan());
			vo.setcName(solrCard.getcName());
			vo.setDef(solrCard.getDef());
			vo.setDescNw(solrCard.getDescNw());
			vo.seteName(solrCard.geteName());
			vo.setHashCode(solrCard.getHashCode());
			vo.setImg(solrCard.getImg());
			vo.setjName(solrCard.getjName());
			vo.setLev(solrCard.getLev());
			vo.setLink(solrCard.getLink());
			vo.setNwName(solrCard.getNwName());
			vo.setPend(solrCard.getPend());
			vo.setProprietary(solrCard.getProprietary());
			vo.setPsd(solrCard.getPsd());
			vo.setRace(solrCard.getRace());
			vo.setType(solrCard.getType());
			Set<String> set = redis.opsForSet().members(vo.getHashCode().toString());
			List<PackInfo> infos = new ArrayList<PackInfo>();
			for (String packs : set) {
				CardPackInfo pack = new ObjectMapper().readValue(packs, CardPackInfo.class);
				PackInfo info = new PackInfo();
				info.setCardNo(pack.getCardNo());
				info.setPackName(pack.getPack());
				info.setRare(pack.getRare());
				info.setSellTime(pack.getSellTime());
				infos.add(info);
			}
			
			vo.setInfos(infos);
			list.add(vo);
		}
		
		return list;
	}

	private Criteria is(Criteria criteria, Object obj, String field) {
		if (obj == null) {
			return criteria;
		}

		String value = obj.toString();
		if (value.trim().equals("")) {
			return criteria;
		}

		return criteria.and(field).is(value.trim());
	}

	private Criteria contains(Criteria criteria, Object obj, String field) {
		if (obj == null) {
			return criteria;
		}

		String value = obj.toString();
		if (value.trim().equals("")) {
			return criteria;
		}

		return criteria.and(field).contains(value.trim());
	}
}
