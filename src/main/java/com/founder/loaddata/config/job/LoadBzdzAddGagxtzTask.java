package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddGagxtzTask;
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
public class LoadBzdzAddGagxtzTask {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddGagxtzTask.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddGagxtzTask> bzdzAddGagxtzTaskReader() throws Exception {

        JdbcPagingItemReader<BzdzAddGagxtzTask> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(2000);
        reader.setPageSize(500);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from BZDZ_ADD_GAGXTZ_TASK");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddGagxtzTask bzdzAddGagxtzTask = new BzdzAddGagxtzTask();

            bzdzAddGagxtzTask.setId(resultSet.getLong("ID"));
            bzdzAddGagxtzTask.setYwtzxxbm(resultSet.getString("YWTZXXBM"));
            bzdzAddGagxtzTask.setJlxdm(resultSet.getString("JLXDM"));
            bzdzAddGagxtzTask.setDzjb(resultSet.getString("DZJB"));
            bzdzAddGagxtzTask.setSjdm(resultSet.getString("SJDM"));
            bzdzAddGagxtzTask.setFxjdm(resultSet.getString("FXJDM"));
            bzdzAddGagxtzTask.setPcsdm(resultSet.getString("pcsdm"));
            bzdzAddGagxtzTask.setZrqdm(resultSet.getString("ZRQDM"));
            bzdzAddGagxtzTask.setTzlx(resultSet.getString("TZLX"));
            bzdzAddGagxtzTask.setSequence(resultSet.getString("SEQUENCE"));

            return bzdzAddGagxtzTask;
        });

        return reader;
    }

    @Bean
    public ItemProcessor bzdzAddGagxtzTaskProcessor() {
        return item -> {
            BzdzAddGagxtzTask b = (BzdzAddGagxtzTask) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddGagxtzTask> bzdzAddGagxtzTaskWriter() {
        return testList -> {
            Map<Long, BzdzAddGagxtzTask> rs = new HashMap<>();
            for (Object bzdzAddGagxtzTask : testList) {
                BzdzAddGagxtzTask b = (BzdzAddGagxtzTask) bzdzAddGagxtzTask;
                rs.put(b.getId(), b);
                logger.debug("{}",b.getId());
            }
            cacheSource.bzdzAddGagxtzTaskRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddGagxtzTask(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddGagxtzTask")
                .chunk(100)
                .reader(bzdzAddGagxtzTaskReader())
                .processor(bzdzAddGagxtzTaskProcessor())
                .writer(bzdzAddGagxtzTaskWriter())
                .build();
    }

}
