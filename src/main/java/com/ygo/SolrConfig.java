package com.ygo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.server.SolrClientFactory;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;

@Configuration
public class SolrConfig {

    @Bean
    @Autowired
    public SolrTemplate solrTemplate(final SolrClientFactory solrClientFactory) {
        return new SolrTemplate(solrClientFactory);
    }

    @Bean
    @Autowired
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder().withBaseSolrUrl("http://127.0.0.1:8889/solr/").build();
    }

    @Bean
    @Autowired
    public SolrClientFactory solrClientFactory(final SolrClient solrClient) {
        return new HttpSolrClientFactory(solrClient);
    }
}