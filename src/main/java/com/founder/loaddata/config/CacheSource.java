package com.founder.loaddata.config;

import com.founder.model.*;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tiger on 2017/2/22.
 */
@Configuration
public class CacheSource {

    public Region<String,BzdzAddJlxxxb> bzdzAddJlxxxbRegion;
    public Region<String,BzdzAddJlxXzqhb> bzdzAddJlxXzqhbRegion;
    public Region<Long,BzdzAddGagxtzTask> bzdzAddGagxtzTaskRegion;
    public Region<String,BzdzAddJlxZzjgb> bzdzAddJlxZzjgbRegion;
    public Region<String,BzdzAddMldzdxb> bzdzAddMldzdxbRegion;
    public Region<String,BzdzAddChdzdxb> bzdzAddChdzdxbRegion;

    @Bean
    public ClientCache getCache(){
        System.setProperty("gemfirePropertyFile", "gfclient.properties");
        ClientCache cache = new ClientCacheFactory().create();
        bzdzAddJlxxxbRegion = cache.getRegion("BZDZ_ADD_JLXXXB");
        bzdzAddJlxXzqhbRegion = cache.getRegion("BZDZ_ADD_JLXXZQHB");
        bzdzAddGagxtzTaskRegion = cache.getRegion("BZDZ_ADD_GAGXTZ_TASK");
        bzdzAddJlxZzjgbRegion = cache.getRegion("BZDZ_ADD_JLXZZJGB");
        bzdzAddMldzdxbRegion = cache.getRegion("BZDZ_ADD_MLDZDXB");
        bzdzAddChdzdxbRegion = cache.getRegion("BZDZ_ADD_CHDZDXB");
        return cache;
    }

}
