package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddMldzdxb;
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
public class LoadBzdzAddMldzdxb {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddMldzdxb.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddMldzdxb> bzdzAddMldzdxbReader() throws Exception {

        JdbcPagingItemReader<BzdzAddMldzdxb> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(10000);
        reader.setPageSize(10000);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from BZDZ_ADD_MLDZDXB");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddMldzdxb bzdzAddMldzdxb = new BzdzAddMldzdxb();

            bzdzAddMldzdxb.setMldzid(resultSet.getString("MLDZID"));
            bzdzAddMldzdxb.setXzqhdm(resultSet.getString("XZQHDM"));
            bzdzAddMldzdxb.setJlxdm(resultSet.getString("JLXDM"));
            bzdzAddMldzdxb.setJlxmc(resultSet.getString("JLXMC"));
            bzdzAddMldzdxb.setSqdm(resultSet.getString("SQDM"));
            bzdzAddMldzdxb.setXqmc(resultSet.getString("XQMC"));
            bzdzAddMldzdxb.setZrqdm(resultSet.getString("ZRQDM"));
            bzdzAddMldzdxb.setPcsdm(resultSet.getString("PCSDM"));
            bzdzAddMldzdxb.setFxjdm(resultSet.getString("FXJDM"));
            bzdzAddMldzdxb.setMplx(resultSet.getString("MPLX"));
            bzdzAddMldzdxb.setMpmc(resultSet.getString("MPMC"));
            bzdzAddMldzdxb.setMpsc(resultSet.getString("MPSC"));
            bzdzAddMldzdxb.setMphbh(resultSet.getString("MPHBH"));
            bzdzAddMldzdxb.setDzmc(resultSet.getString("DZMC"));
            bzdzAddMldzdxb.setDzmcpy(resultSet.getString("DZMCPY"));
            bzdzAddMldzdxb.setDzmcpwd(resultSet.getString("DZMCPWD"));
            bzdzAddMldzdxb.setDzmcpypwd(resultSet.getString("DZMCPYPWD"));
            bzdzAddMldzdxb.setMpzbx(resultSet.getString("MPZBX"));
            bzdzAddMldzdxb.setMpzby(resultSet.getString("MPZBY"));
            bzdzAddMldzdxb.setDtcwfk(resultSet.getString("DTCWFK"));
            bzdzAddMldzdxb.setXzqhsc(resultSet.getString("XZQHSC"));
            bzdzAddMldzdxb.setDzsjly(resultSet.getString("DZSJLY"));
            bzdzAddMldzdxb.setBz(resultSet.getString("BZ"));
            bzdzAddMldzdxb.setQxgxid(resultSet.getString("QXGXID"));
            bzdzAddMldzdxb.setXzjdbscid(resultSet.getString("XZJDBSCID"));
            bzdzAddMldzdxb.setSflj(resultSet.getString("SFLJ"));
            bzdzAddMldzdxb.setJzwbm(resultSet.getString("JZWBM"));
            bzdzAddMldzdxb.setJzwmj(resultSet.getString("JZWMJ"));
            bzdzAddMldzdxb.setSfscfw(resultSet.getString("SFSCFW"));
            bzdzAddMldzdxb.setXqid(resultSet.getString("XQID"));
            bzdzAddMldzdxb.setMphhz_hfh(resultSet.getString("MPHHZ_HFH"));
            bzdzAddMldzdxb.setSftxjzwxx(resultSet.getString("SFTXJZWXX"));
            bzdzAddMldzdxb.setMphhz(resultSet.getString("MPHHZ"));
            bzdzAddMldzdxb.setMphhz_zhfh(resultSet.getString("MPHHZ_ZHFH"));
            bzdzAddMldzdxb.setShiid(resultSet.getString("SHIID"));
            bzdzAddMldzdxb.setSjdm(resultSet.getString("SJDM"));
            bzdzAddMldzdxb.setMph(resultSet.getString("MPH"));
            bzdzAddMldzdxb.setOld_mldzid(resultSet.getString("OLD_MLDZID"));

            return bzdzAddMldzdxb;
        });

        return reader;
    }

    @Bean
    public ItemProcessor bzdzAddMldzdxbProcessor() {
        return item -> {
            BzdzAddMldzdxb b = (BzdzAddMldzdxb) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddMldzdxb> bzdzAddMldzdxbWriter() {
        return testList -> {
            Map<String, BzdzAddMldzdxb> rs = new HashMap<>();
            for (Object bzdzAddMldzdxb : testList) {
                BzdzAddMldzdxb b = (BzdzAddMldzdxb) bzdzAddMldzdxb;
                rs.put(b.getMldzid(), b);
                logger.debug("{}",b.getMldzid());
            }
            cacheSource.bzdzAddMldzdxbRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddMldzdxb(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddMldzdxb")
                .chunk(100)
                .reader(bzdzAddMldzdxbReader())
                .processor(bzdzAddMldzdxbProcessor())
                .writer(bzdzAddMldzdxbWriter())
                .build();
    }

}
