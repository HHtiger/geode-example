package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddJlxxxb;
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
public class LoadBzdzAddJlxxxbJob {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddJlxxxbJob.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddJlxxxb> bzdzAddJlxxxbReader() throws Exception {

        JdbcPagingItemReader<BzdzAddJlxxxb> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(2000);
        reader.setPageSize(500);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from bzdz_add_jlxxxb");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddJlxxxb bzdzAddJlxxxb = new BzdzAddJlxxxb();
            bzdzAddJlxxxb.setJlxid(resultSet.getString("JLXID"));
            bzdzAddJlxxxb.setJlxdm(resultSet.getString("JLXDM"));
            bzdzAddJlxxxb.setJlxmc(resultSet.getString("JLXMC"));
            bzdzAddJlxxxb.setJlxlx(resultSet.getString("JLXLX"));
            bzdzAddJlxxxb.setDlst(resultSet.getString("DLST"));
            bzdzAddJlxxxb.setJlxpy(resultSet.getString("JLXPY"));
            bzdzAddJlxxxb.setJlxwb(resultSet.getString("JLXWB"));
            bzdzAddJlxxxb.setBz(resultSet.getString("BZ"));
            bzdzAddJlxxxb.setSc(resultSet.getString("SC"));
            bzdzAddJlxxxb.setMzbmmmqk(resultSet.getString("MZBMMMQK"));
            bzdzAddJlxxxb.setQdzb(resultSet.getString("QDZB"));
            bzdzAddJlxxxb.setZdzb(resultSet.getString("ZDZB"));
            bzdzAddJlxxxb.setXt_hssj(resultSet.getString("XT_HSSJ"));
            return bzdzAddJlxxxb;
        });

        return reader;
    }

    @Bean
    public ItemProcessor bzdzAddJlxxxbProcessor() {
        return item -> {
            BzdzAddJlxxxb b = (BzdzAddJlxxxb) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddJlxxxb> bzdzAddJlxxxbWriter() {
        return testList -> {
            Map<String, BzdzAddJlxxxb> rs = new HashMap<>();
            for (Object bzdzAddJlxxxb : testList) {
                BzdzAddJlxxxb b = (BzdzAddJlxxxb) bzdzAddJlxxxb;
                rs.put(b.getJlxid(), b);
                logger.debug(b.getJlxid());
            }
            cacheSource.bzdzAddJlxxxbRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddJlxxxb(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddJlxxxb")
                .chunk(100)
                .reader(bzdzAddJlxxxbReader())
                .processor(bzdzAddJlxxxbProcessor())
                .writer(bzdzAddJlxxxbWriter())
                .build();
    }

}
