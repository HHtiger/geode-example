package com.founder.loaddata.config.job;

import com.founder.loaddata.config.CacheSource;
import com.founder.loaddata.config.DataSource;
import com.founder.model.BzdzAddChdzdxb;
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
public class LoadBzdzAddChdzdxb {

    private static Logger logger = LoggerFactory.getLogger(LoadBzdzAddChdzdxb.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CacheSource cacheSource;

    @Bean
    public JdbcPagingItemReader<BzdzAddChdzdxb> bzdzAddChdzdxbReader() throws Exception {

        JdbcPagingItemReader<BzdzAddChdzdxb> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource.druidDataSource());
        reader.setFetchSize(2000);
        reader.setPageSize(500);
        SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
        sqlPagingQueryProviderFactoryBean.setDataSource(dataSource.druidDataSource());
        sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
        sqlPagingQueryProviderFactoryBean.setFromClause("from BZDZ_ADD_CHDZDXB");
        sqlPagingQueryProviderFactoryBean.setSortKey("xt_lrsj");

        reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
        reader.setRowMapper((resultSet, i) -> {
            BzdzAddChdzdxb bzdzAddChdzdxb = new BzdzAddChdzdxb();
            
            bzdzAddChdzdxb.setChdzid(resultSet.getString("CHDZID"));
            bzdzAddChdzdxb.setMldzid(resultSet.getString("MLDZID"));
            bzdzAddChdzdxb.setDzjb(resultSet.getString("DZJB"));
            bzdzAddChdzdxb.setDyh(resultSet.getString("DYH"));
            bzdzAddChdzdxb.setDyhlx(resultSet.getString("DYHLX"));
            bzdzAddChdzdxb.setDyhhz(resultSet.getString("DYHHZ"));
            bzdzAddChdzdxb.setDyhsc(resultSet.getString("DYHSC"));
            bzdzAddChdzdxb.setDyzbx(resultSet.getString("DYZBX"));
            bzdzAddChdzdxb.setDyzby(resultSet.getString("DYZBY"));
            bzdzAddChdzdxb.setDyhdm(resultSet.getString("DYHDM"));
            bzdzAddChdzdxb.setDyhmc(resultSet.getString("DYHMC"));
            bzdzAddChdzdxb.setLchhz(resultSet.getString("LCHHZ"));
            bzdzAddChdzdxb.setLphsc(resultSet.getString("LPHSC"));
            bzdzAddChdzdxb.setLchsc(resultSet.getString("LCHSC"));
            bzdzAddChdzdxb.setLplx(resultSet.getString("LPLX"));
            bzdzAddChdzdxb.setLph(resultSet.getString("LPH"));
            bzdzAddChdzdxb.setLch(resultSet.getString("LCH"));
            bzdzAddChdzdxb.setLphdm(resultSet.getString("LPHDM"));
            bzdzAddChdzdxb.setLphmc(resultSet.getString("LPHMC"));
            bzdzAddChdzdxb.setLphpy(resultSet.getString("LPHPY"));
            bzdzAddChdzdxb.setLphhz(resultSet.getString("LPHHZ"));
            bzdzAddChdzdxb.setLpzbx(resultSet.getString("LPZBX"));
            bzdzAddChdzdxb.setLpzby(resultSet.getString("LPZBY"));
            bzdzAddChdzdxb.setLchdm(resultSet.getString("LCHDM"));
            bzdzAddChdzdxb.setLchlx(resultSet.getString("LCHLX"));
            bzdzAddChdzdxb.setLchmc(resultSet.getString("LCHMC"));
            bzdzAddChdzdxb.setFjhhz(resultSet.getString("FJHHZ"));
            bzdzAddChdzdxb.setFjhsc(resultSet.getString("FJHSC"));
            bzdzAddChdzdxb.setFjhdm(resultSet.getString("FJHDM"));
            bzdzAddChdzdxb.setFjhlx(resultSet.getString("FJHLX"));
            bzdzAddChdzdxb.setFjh(resultSet.getString("FJH"));
            bzdzAddChdzdxb.setFjhmc(resultSet.getString("FJHMC"));
            bzdzAddChdzdxb.setFjhbs(resultSet.getString("FJHBS"));
            bzdzAddChdzdxb.setDzmc(resultSet.getString("DZMC"));
            bzdzAddChdzdxb.setDzmcpy(resultSet.getString("DZMCPY"));
            bzdzAddChdzdxb.setDzmcpwd(resultSet.getString("DZMCPWD"));
            bzdzAddChdzdxb.setDzmcpypwd(resultSet.getString("DZMCPYPWD"));
            bzdzAddChdzdxb.setBz(resultSet.getString("BZ"));
            bzdzAddChdzdxb.setSqdm(resultSet.getString("SQDM"));
            bzdzAddChdzdxb.setZrqdm(resultSet.getString("ZRQDM"));
            bzdzAddChdzdxb.setPcsdm(resultSet.getString("PCSDM"));
            bzdzAddChdzdxb.setFxjdm(resultSet.getString("FXJDM"));
            bzdzAddChdzdxb.setLphhzhfh(resultSet.getString("LPHHZHFH"));
            bzdzAddChdzdxb.setJzwbm(resultSet.getString("JZWBM"));
            bzdzAddChdzdxb.setSflj(resultSet.getString("SFLJ"));
            bzdzAddChdzdxb.setSfxzfw(resultSet.getString("SFXZFW"));
            bzdzAddChdzdxb.setJzwmj(resultSet.getString("JZWMJ"));
            bzdzAddChdzdxb.setFjhhzhfh(resultSet.getString("FJHHZHFH"));
            bzdzAddChdzdxb.setLcwz(resultSet.getString("LCWZ"));
            bzdzAddChdzdxb.setParenttreepath(resultSet.getString("PARENTTREEPATH"));
            bzdzAddChdzdxb.setSftxjzwxx(resultSet.getString("SFTXJZWXX"));
            bzdzAddChdzdxb.setOld_chdzid(resultSet.getString("OLD_CHDZID"));
            bzdzAddChdzdxb.setSjdm(resultSet.getString("SJDM"));
            
            return bzdzAddChdzdxb;
        });

        return reader;
    }

    @Bean
    public ItemProcessor bzdzAddChdzdxbProcessor() {
        return item -> {
            BzdzAddChdzdxb b = (BzdzAddChdzdxb) item;
            return b;
        };
    }

    @Bean
    public ItemWriter<BzdzAddChdzdxb> bzdzAddChdzdxbWriter() {
        return testList -> {
            Map<String, BzdzAddChdzdxb> rs = new HashMap<>();
            for (Object bzdzAddChdzdxb : testList) {
                BzdzAddChdzdxb b = (BzdzAddChdzdxb) bzdzAddChdzdxb;
                rs.put(b.getMldzid(), b);
                logger.debug("{}",b.getMldzid());
            }
            cacheSource.bzdzAddChdzdxbRegion.putAll(rs);
        };
    }

    @Bean
    public Step stepBzdzAddChdzdxb(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("stepBzdzAddChdzdxb")
                .chunk(100)
                .reader(bzdzAddChdzdxbReader())
                .processor(bzdzAddChdzdxbProcessor())
                .writer(bzdzAddChdzdxbWriter())
                .build();
    }

}
