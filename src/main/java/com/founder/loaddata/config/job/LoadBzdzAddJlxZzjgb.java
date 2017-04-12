package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddJlxZzjgb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
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
public class LoadBzdzAddJlxZzjgb {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddJlxZzjgb.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddJlxZzjgb> bzdzAddJlxZzjgbReader() throws Exception {

        JdbcPagingItemReader<BzdzAddJlxZzjgb> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(2000);
        reader.setPageSize(500);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from BZDZ_ADD_JLXZZJGB");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddJlxZzjgb bzdzAddJlxZzjgb = new BzdzAddJlxZzjgb();

            bzdzAddJlxZzjgb.setJlxzzjgid(resultSet.getString("JLXZZJGID"));
            bzdzAddJlxZzjgb.setJlxdm(resultSet.getString("JLXDM"));
            bzdzAddJlxZzjgb.setZrqdm(resultSet.getString("ZRQDM"));
            bzdzAddJlxZzjgb.setPcsdm(resultSet.getString("PCSDM"));
            bzdzAddJlxZzjgb.setFxjdm(resultSet.getString("FXJDM"));
            bzdzAddJlxZzjgb.setSjdm(resultSet.getString("SJDM"));

            return bzdzAddJlxZzjgb;
        });

        return reader;
    }

    @Bean
    public ItemProcessor bzdzAddJlxZzjgbProcessor() {
        return item -> {
            BzdzAddJlxZzjgb b = (BzdzAddJlxZzjgb) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddJlxZzjgb> bzdzAddJlxZzjgbWriter() {
        return testList -> {
            Map<String, BzdzAddJlxZzjgb> rs = new HashMap<>();
            for (Object bzdzAddJlxZzjgb : testList) {
                BzdzAddJlxZzjgb b = (BzdzAddJlxZzjgb) bzdzAddJlxZzjgb;
                rs.put(b.getJlxzzjgid(), b);
                logger.debug("{}",b.getJlxzzjgid());
            }
            cacheSource.bzdzAddJlxZzjgbRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddJlxZzjgb(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddJlxZzjgb")
                .chunk(100)
                .reader(bzdzAddJlxZzjgbReader())
                .processor(bzdzAddJlxZzjgbProcessor())
                .writer(bzdzAddJlxZzjgbWriter())
                .build();
    }

}
