package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddJlxXzqhb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiger on 2017/2/21.
 */
@Configuration
@EnableBatchProcessing
public class LoadBzdzAddJlxXzqhbJob {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddJlxXzqhbJob.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddJlxXzqhb> BzdzAddJlxXzqhbReader() throws Exception {

        JdbcPagingItemReader<BzdzAddJlxXzqhb> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(2000);
        reader.setPageSize(500);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from bzdz_add_jlxxzqhb");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddJlxXzqhb bzdzAddJlxXzqhb = new BzdzAddJlxXzqhb();
            bzdzAddJlxXzqhb.setJlxdm(resultSet.getString("JLXDM"));
            bzdzAddJlxXzqhb.setJlxxzqhid(resultSet.getString("JLXXZQHID"));
            bzdzAddJlxXzqhb.setXzqhdm(resultSet.getString("XZQHDM"));
            return bzdzAddJlxXzqhb;
        });

        return reader;
    }

    @Bean
    public ItemProcessor BzdzAddJlxXzqhbProcessor() {
        return item -> {
            BzdzAddJlxXzqhb b = (BzdzAddJlxXzqhb) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddJlxXzqhb> BzdzAddJlxXzqhbWriter() {
        return testList -> {
            Map<String, BzdzAddJlxXzqhb> rs = new HashMap<>();
            for (Object bzdzAddJlxxxb : testList) {
                BzdzAddJlxXzqhb b = (BzdzAddJlxXzqhb) bzdzAddJlxxxb;
                rs.put(b.getJlxxzqhid(), b);
                logger.debug(b.getJlxxzqhid());
            }
            cacheSource.bzdzAddJlxXzqhbRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddJlxXzqhb(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddJlxXzqhb")
                .chunk(100)
                .reader(BzdzAddJlxXzqhbReader())
                .processor(BzdzAddJlxXzqhbProcessor())
                .writer(BzdzAddJlxXzqhbWriter())
                .build();
    }

}
